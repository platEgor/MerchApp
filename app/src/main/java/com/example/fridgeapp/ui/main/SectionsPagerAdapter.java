package com.example.fridgeapp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fridgeapp.AddProduct;
import com.example.fridgeapp.MyFridge;
import com.example.fridgeapp.R;
import com.example.fridgeapp.Settings;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                AddProduct tab1 = new AddProduct();
                return tab1;
            case 1:
                MyFridge tab2 = new MyFridge();
                return tab2;
            case 2:
                Settings tab3 = new Settings();
                return tab3;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Добавить продукт";
            case 1:
                return "Мой холодильник";
            case 2:
                return "Настройки";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}