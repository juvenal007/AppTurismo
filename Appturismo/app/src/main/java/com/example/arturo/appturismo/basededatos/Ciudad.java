package com.example.arturo.appturismo.basededatos;


public class Ciudad {
    public int id;
    public String nombre;
    public int foto1;
    public int foto2;
    public String descripcion;

    public Ciudad(){

    }

    public Ciudad(int id, String nombre, int foto1, int foto2, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.descripcion = descripcion;
    }

    public Ciudad(String nombre, int foto1, int foto2, String descripcion) {
        this.nombre = nombre;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFoto1() {
        return foto1;
    }

    public int getFoto2() {
        return foto2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFoto1(int foto1) {
        this.foto1 = foto1;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
