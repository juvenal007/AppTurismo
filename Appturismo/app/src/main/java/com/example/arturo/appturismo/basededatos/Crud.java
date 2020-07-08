package com.example.arturo.appturismo.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Crud {

    private ConexionHelper helper;
    private SQLiteDatabase db;
    private ContentValues values;

    public Crud(Context context) {
        helper = new ConexionHelper(context);
        values = new ContentValues();

    }


    public void insertar(Ciudad ciudad){
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.NOMBRE, ciudad.nombre);
        values.put(ConexionHelper.IMAGEN1, ciudad.foto1);
        values.put(ConexionHelper.IMAGEN2, ciudad.foto2);
        values.put(ConexionHelper.DESCRIPCION, ciudad.descripcion);
        db.insert(ConexionHelper.TABLA, null, values);
        db.close();
    }

    public void eliminar(int id){
        String pk = id+"";
        helper.getWritableDatabase();
        db.delete(ConexionHelper.TABLA, ConexionHelper.ID+"=?", new String[]{pk});
        db.close();
    }

    public void actualizar(Ciudad ciudad){
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.NOMBRE, ciudad.nombre);
        values.put(ConexionHelper.IMAGEN1, ciudad.foto1);
        values.put(ConexionHelper.IMAGEN2, ciudad.foto2);
        values.put(ConexionHelper.DESCRIPCION, ciudad.descripcion);



        String pk = ciudad.getId()+"";
        db.update(ConexionHelper.TABLA, values, ConexionHelper.ID+"=?", new String[]{pk});
        db.close();

    }

    public Ciudad buscar(int id){
        Ciudad ciudad = new Ciudad();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ConexionHelper.TABLA+" where id=?",
                new String[]{String.valueOf(id)});
        if (cursor.moveToNext()){
            ciudad.setId(cursor.getInt(0));
            ciudad.setNombre(cursor.getString(1));
            ciudad.setFoto1(cursor.getInt(2));
            ciudad.setFoto2(cursor.getInt(3));
            ciudad.setDescripcion(cursor.getString(4));
        }
        db.close();
        return ciudad;
    }

    public List<Ciudad> List(){
        List<Ciudad> list = new ArrayList<>();
        db = helper.getWritableDatabase();
        String sql = "select * from "+ConexionHelper.TABLA;
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Ciudad ciudad = new Ciudad();
            ciudad.setId(cursor.getInt( 0));
            ciudad.setNombre(cursor.getString( 1));
            ciudad.setFoto1(cursor.getInt( 2));
            ciudad.setFoto2(cursor.getInt( 3));
            ciudad.setDescripcion(cursor.getString( 4));
            list.add(ciudad);
        }
        db.close();
        return list;
    }

}
