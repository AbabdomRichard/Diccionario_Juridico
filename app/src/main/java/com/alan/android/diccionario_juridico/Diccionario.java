package com.alan.android.diccionario_juridico;

/**
 * Created by Alan on 11/05/2016.
 */
public class Diccionario {
    public String nombre = "";
    public String significado= "";

    public Diccionario(String string, String cursorString, String s) {

    }


    public String getNombre() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getSignificado() {
        return significado;
    }

    public void setMobileNo(String significado) {
        this.significado= significado;
    }


    // constructor
    public Diccionario(String string, String cursorString) {

        this.significado = significado;
        this.nombre = nombre;
    }

    public Diccionario() {

    }
}