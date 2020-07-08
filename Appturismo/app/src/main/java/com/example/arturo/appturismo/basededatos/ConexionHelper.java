package com.example.arturo.appturismo.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.R.*;
import com.example.arturo.appturismo.R;

public class ConexionHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "appturismo";
    private static final int VERSION = 1;

    public static final String TABLA = "ciudad";
    public static final String ID = "id";
    public static final String NOMBRE = "nombrePlato";
    public static final String IMAGEN1 = "imagen1";
    public static final String IMAGEN2 = "imagen2";
    public static final String DESCRIPCION = "descripcion";

    public ConexionHelper(Context context){super(context,DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String script = "";
        script = "create table "+TABLA+"("+ID+" integer primary key autoincrement,";
        script +=NOMBRE+" text,";
        script +=IMAGEN1+" text,";
        script +=IMAGEN2+" text,";
        script +=DESCRIPCION+" text";
        script +=");";
        db.execSQL(script);
        db.execSQL("insert into "+TABLA+" values(null,'Talca',"+R.drawable.talca1+","+R.drawable.talca1f1+",'Comuna de Talca en la Región del Maule. Talca es una ciudad y comuna de la zona central de Chile, capital de la provincia homónima y de la Región del Maule.');");
        db.execSQL("insert into "+TABLA+" values(null,'Linares',"+R.drawable.linares1+","+R.drawable.linares1f1+",'Linares (Chile) ... Linares (fundada oficialmente como Villa San Ambrosio de Linares) es una comuna y ciudad de Chile, capital de la provincia de Linares. ');");
        db.execSQL("insert into "+TABLA+" values(null,'Curico',"+R.drawable.curico1+","+R.drawable.curico1f1+",'Curicó (en mapuche: kurü ko, aguas negras) es una ciudad y capital de la Provincia de Curicó, ubicada en la región del Maule zona centro de Chile.');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }
}
