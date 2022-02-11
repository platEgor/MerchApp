package com.example.fridgeapp;

import java.util.Date;

class Product {
    String name;
    Date exp_date;

    public Product(String n, Date e_d) {
        name = n;
        exp_date = e_d;
    }
}