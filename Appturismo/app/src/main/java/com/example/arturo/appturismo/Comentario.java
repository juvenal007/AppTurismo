package com.example.arturo.appturismo;

public class Comentario {

    public int id;
    public String nombre;
    public String comentario;


    public Comentario(String nombre, String comentario, int id) {
        this.id = id;
        this.nombre = nombre;
        this.comentario = comentario;
    }
    public Comentario(String nombre, String comentario){
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public Comentario(){

    }

}
