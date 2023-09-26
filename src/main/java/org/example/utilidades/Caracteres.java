package org.example.utilidades;

public class Caracteres {

    public static Boolean minimoLetras(String nombre, Integer caracteres){
        return nombre.length() >= caracteres;
    }

    public static Boolean maximoLetras(String campo,Integer caracteres){
        return campo.length() <= caracteres;
    }


}
