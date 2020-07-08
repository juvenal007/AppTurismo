package com.example.arturo.appturismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.arturo.appturismo.basededatos.Crud;
import com.example.arturo.appturismo.basededatos.Ciudad;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Detalle extends AppCompatActivity {

    private RecyclerView recycler;
    private TextView nombre,descripcion;
    private ImageView foto2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);



        Toolbar toolbar_menu_detalle = findViewById(R.id.my_toolbar);
        String id = getIntent().getStringExtra("id");

        Crud crud = new Crud(this);

        Ciudad ciudad = crud.buscar(Integer.parseInt(id));

        setSupportActionBar(toolbar_menu_detalle);
        setTitle("Ciudad");
        getSupportActionBar().setSubtitle(ciudad.getNombre());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        buscarComentarios(Integer.parseInt(id));

        recycler = findViewById(R.id.list_recycler_comentario);

        nombre = findViewById(R.id.nombre_detalle);
        nombre.setText(ciudad.getNombre());

        foto2 = findViewById(R.id.item_foto_detalle);
        foto2.setImageResource(ciudad.getFoto2());

        descripcion = findViewById(R.id.descripcion_detalle);
        descripcion.setText(ciudad.getDescripcion());

    }



    @Override
    protected void onResume() {
        String id = getIntent().getStringExtra("id");
        buscarComentarios(Integer.parseInt(id));
        super.onResume();
    }

    public void addComentario(View view){
        String id = getIntent().getStringExtra("id");
        Intent intent = new Intent(this, AgregarComentario.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }


    public void buscarComentarios(int id){
        String Url="http://raspberry.todojava.net/index.php/buscarComentarios";
        RequestParams params = new RequestParams();
        params.put("id",id);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    String respuesta = new String(responseBody);
                    cargaComentarios(respuesta);
                    Log.e("INFO", respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }



    public void cargaComentarios(String respuesta){
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(lm);

        try {

            List<Comentario> list = new ArrayList<>();
            JSONArray json = new JSONArray(respuesta);

            for (int i = 0; i < json.length(); i++){
                Comentario c = new Comentario();
                c.id = json.getJSONObject(i).getInt("id");
                c.nombre = json.getJSONObject(i).getString("nombre");
                c.comentario = json.getJSONObject(i).getString("comentario");
                list.add(c);
            }

            AdaptadorComentario ad = new AdaptadorComentario(list, this, R.layout.item_comentario);
            recycler.setAdapter(ad);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
