package com.example.fridgeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //этот список, по задумке, приложение должно брать с сервера, но ввиду технических проблем, реализовать запросы с сервера не удалось :(. Ещё к сессии готовиться надо((((.
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"user1", "1234"));
        users.add(new User(2,"user2", "2345"));

        Intent intent = getIntent();
        boolean ifReload = intent.getExtras().getBoolean("ifReload");
        if (ifReload){
            Intent intent2 = new Intent(Login.this, MainActivity.class);
            startActivity(intent2);
        }

        EditText nameT = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText passT = (EditText) findViewById(R.id.editTextTextPassword4);
        Button singIn = (Button) findViewById(R.id.button);

        TextView tv = (TextView) findViewById(R.id.textView3);

        singIn.setOnClickListener(v -> {
            try {
                String name = nameT.getText().toString();
                String password = passT.getText().toString();
                int id = 0;
                for (int i = 0; i < users.size(); i++){
                    if (name.equals(users.get(i).name)){
                        if (password.equals(users.get(i).password)){
                            id = users.get(i).ident;
                        }
                    }
                }
                if (id != 0){
                    Intent intent3 = new Intent(Login.this, MainActivity.class);
                    intent3.putExtra("id", id);
                    startActivity(intent3);
                }
                else{
                    tv.setText("Имя пользователя или пароль неверны. Попробуйте ещё раз.");
                    passT.setText("");
                }
            } catch (Exception e){
                TextView tv1 = (TextView) findViewById(R.id.textView3);
                tv1.setText("Имя пользователя или пароль неверны. Попробуйте ещё раз.");
                passT.setText("");
            }

        });
    }
}
