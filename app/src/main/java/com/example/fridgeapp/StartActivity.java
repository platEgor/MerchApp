package com.example.fridgeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((FridgeList) this.getApplication()).alterFridges();
        Intent i = new Intent(StartActivity.this, Login.class);
        i.putExtra("ifReload", false);
        startActivity(i);

    }
}
