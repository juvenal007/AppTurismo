package com.example.arturo.appturismo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Acerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        Toolbar toolbar_menu_acerca = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar_menu_acerca);
        setTitle("Acerca");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
