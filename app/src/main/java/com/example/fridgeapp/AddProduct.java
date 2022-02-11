package com.example.fridgeapp;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AddProduct extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        View root = inflater.inflate(R.layout.add_product, container, false);

        Button btn = (Button) root.findViewById(R.id.button3);
        TextView tv = (TextView) root.findViewById(R.id.textView4);
        EditText nameT = (EditText) root.findViewById(R.id.editTextTextPersonName);
        EditText dateT = (EditText) root.findViewById(R.id.editTextDate);

        Button scanBtn = (Button) root.findViewById(R.id.button4);
        scanBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Camera.class);
            startActivity(intent);
        });

        btn.setOnClickListener(v -> {
            try{
                String name = nameT.getText().toString();
                Date date = format.parse(dateT.getText().toString());
                ArrayList<Product> products = ((FridgeList) getActivity().getApplication()).getFridgeProducts();
                products.add(new Product(name, date));
                ((FridgeList) getActivity().getApplication()).setFridgeProducts(products);
                tv.setTextColor(Color.rgb(0,0,0));
                tv.setText("Продукт добавлен.");
                System.out.println(((FridgeList) getActivity().getApplication()).getFridgeProducts() + "!!!");
            }catch(Exception e){
                tv.setTextColor(Color.rgb(255,0,0));
                tv.setText("Дата в неправильном формате, или отсутствует имя.");
            }
        });
        return root;
    }
}
