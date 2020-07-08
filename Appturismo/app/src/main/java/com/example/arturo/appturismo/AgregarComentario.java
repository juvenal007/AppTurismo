package com.example.arturo.appturismo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class AgregarComentario extends AppCompatActivity {

    private EditText nombreS,comentarioS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        nombreS = findViewById(R.id.txt_new_nombre);
        comentarioS = findViewById(R.id.txt_new_comentario);

        Toolbar toolbar_menu_opinion = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar_menu_opinion);
        setTitle("Opiniones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void agregarComentario(View view){
        Comentario c = new Comentario();
        nombreS = findViewById(R.id.txt_new_nombre);
        comentarioS = findViewById(R.id.txt_new_comentario);
        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        String nombre = nombreS.getText().toString();
        String comentario = comentarioS.getText().toString();
        if (nombre.isEmpty() || comentario.isEmpty()){
            Toast.makeText(AgregarComentario.this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }else{
            c.id = id;
            c.nombre = nombre;
            c.comentario = comentario;
            insertarComentarios(c);
        //    Log.e("INFO",nombre+comentario);
            finish();
        }

    }
    public void insertarComentarios(Comentario c){
        String Url="http://raspberry.todojava.net/index.php/insertarComentario";
        RequestParams params = new RequestParams();
        params.put("id", c.id);
        params.put("nombre",c.nombre);
        params.put("comentario", c.comentario);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    String respuesta = new String(responseBody);
                    Toast.makeText(AgregarComentario.this, "Comentario agregado", Toast.LENGTH_SHORT).show();
                    Log.e("INFO", respuesta);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.e(  "INFO", "error");
            }
        });
    }



}
