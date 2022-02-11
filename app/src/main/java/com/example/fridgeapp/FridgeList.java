package com.example.fridgeapp;

import android.app.Application;
import android.widget.LinearLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

//Не удалось осуществить запрсы с сервера, поэтому представьте, что этот файл и есть сервер.

public class FridgeList extends Application {
    private ArrayList<Product> prods = new ArrayList<>();
    private Fridge fridge = new Fridge(prods);

    public void alterFridges() {
        DateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        ArrayList<Product> products1 = new ArrayList<>();
        ArrayList<Product> products2 = new ArrayList<>();
        try {
            products1.add(new Product("Сметана", format.parse("Jan 3, 2020")));
            products1.add(new Product("Сыр", format.parse("Nov 20, 2020")));
            products1.add(new Product("Йогурт", format.parse("Dec 25, 2020")));
            products1.add(new Product("Творог", format.parse("Dec 14, 2020")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fridge.products = products1;

    }
    public Fridge getFridge() {
        return fridge;
    }
    public ArrayList<Product> getFridgeProducts() {
        return fridge.products;
    }
    public void setFridgeProducts(ArrayList<Product> products) {
        fridge.products = products;
    }

    public void setFridges(Fridge fridge) {
        this.fridge = fridge;
    }
}
