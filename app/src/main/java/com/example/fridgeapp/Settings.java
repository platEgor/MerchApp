package com.example.fridgeapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Settings extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.settings, container, false);

        TextView tv = (TextView) root.findViewById(R.id.textView5);

        Button btn = (Button) root.findViewById(R.id.button5);
        btn.setOnClickListener(v -> {
            tv.setText("Настройки применены.");
        });

        Button btn2 = (Button) root.findViewById(R.id.button6);
        btn2.setOnClickListener(v -> {
            Intent i = new Intent(getContext(), Login.class);
            i.putExtra("ifReload", false);
            startActivity(i);
        });

        return root;
    }
}