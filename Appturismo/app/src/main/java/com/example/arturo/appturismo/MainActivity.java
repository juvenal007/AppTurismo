package com.example.arturo.appturismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.arturo.appturismo.basededatos.Crud;
import com.example.arturo.appturismo.basededatos.Ciudad;

import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar_menu = findViewById(R.id.my_toolbar);


        setSupportActionBar(toolbar_menu);
        setTitle("AppTurismo");


        Crud crud = new Crud(this);

        List<Ciudad> list = crud.List();

        RecyclerView rc = findViewById(R.id.list_recycler);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        rc.setLayoutManager(lm);

        AdaptadorCiudad adaptador = new AdaptadorCiudad(list,
                this, R.layout.item_ciudad);
        rc.setAdapter(adaptador);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                    Acerca();
                break;
        }
        return true;
    }

    public void Acerca(){
        Intent intent = new Intent(this, Acerca.class);
        startActivity(intent);
    }




}
