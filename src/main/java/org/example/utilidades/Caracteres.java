package org.example.utilidades;

/**
 * Esta clase proporciona métodos para verificar la longitud de cadenas de texto.
 */
public class Caracteres {

    /**
     * Comprueba si una cadena de texto tiene al menos el número mínimo de caracteres especificado.
     *
     * @param nombre      La cadena de texto que se va a comprobar.
     * @param caracteres El número mínimo de caracteres requeridos.
     * @return true si la cadena tiene al menos el número mínimo de caracteres, de lo contrario false.
     */
    public static Boolean minimoLetras(String nombre, Integer caracteres){
        return nombre.length() >= caracteres;
    }

    /**
     * Comprueba si una cadena de texto no excede el número máximo de caracteres especificado.
     *
     * @param campo      La cadena de texto que se va a comprobar.
     * @param caracteres El número máximo de caracteres permitidos.
     * @return true si la cadena no excede el número máximo de caracteres, de lo contrario false.
     */
    public static Boolean maximoLetras(String campo,Integer caracteres){
        return campo.length() <= caracteres;
    }


}
