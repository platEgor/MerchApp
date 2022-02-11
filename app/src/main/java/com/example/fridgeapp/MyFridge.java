package com.example.fridgeapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;


public class MyFridge extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.my_fridge, container, false);

        Fridge fridge = new Fridge(((FridgeList) getActivity().getApplication()).getFridgeProducts());

        LinearLayout productList = (LinearLayout) root.findViewById(R.id.product_list);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,0,0,50);

        Button btn = (Button) root.findViewById(R.id.button2);
        btn.setOnClickListener(v -> {
            Intent i = new Intent(getContext(), Login.class);
            i.putExtra("ifReload", true);
            startActivity(i);
        });

        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < fridge.products.size(); i++)
            products.add(fridge.products.get(i));

        Date date = new Date();

        for (int i = 0; i < products.size(); i++) {
            final int[] a = {0};
            final int[] b = {0};
            Button prod = new Button(this.getContext());
            prod.setLayoutParams(lp);
            prod.setTextColor(Color.rgb(255, 255, 255));
            long days = TimeUnit.DAYS.convert(products.get(i).exp_date.getTime() - date.getTime(), TimeUnit.MILLISECONDS);
            if (days >= 0) {
                prod.setBackgroundColor(Color.rgb(0, 200, 0));
                prod.setText(products.get(i).name + "\n" + days + " дней до истечения срока годности");
            } else {
                prod.setBackgroundColor(Color.rgb(255, 100, 100));
                prod.setText(products.get(i).name + "\n" + "просрочен на " + days*(-1) + " дней");
            }
            prod.setAllCaps(false);
            prod.setTextSize(20);
            prod.setGravity(Gravity.LEFT);
            int finalI = i;
            long daysF = days;
            ArrayList<Product> finalProducts = products;
            prod.setOnClickListener(v -> {
                if (daysF < 0){
                    finalProducts.remove(finalProducts.get(finalI));
                    productList.removeView(prod);
                }
                //products.set(finalProducts);
                ((FridgeList) getActivity().getApplication()).setFridgeProducts(finalProducts);
            });
            productList.addView(prod);
        }
        return root;
    }
}
