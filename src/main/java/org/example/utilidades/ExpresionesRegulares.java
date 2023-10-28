package org.example.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase proporciona un método para verificar si una cadena de texto cumple con una expresión regular dada.
 */
public class ExpresionesRegulares {

    /**
     * Verifica si una cadena de texto cumple con una expresión regular especificada.
     *
     * @param nombre  La cadena de texto que se va a verificar.
     * @param regExp La expresión regular que se utilizará para la verificación.
     * @return true si la cadena de texto cumple con la expresión regular, de lo contrario false.
     */
    public static Boolean regExp(String nombre,String regExp){
        Pattern patron = Pattern.compile(regExp);
        Matcher validacion = patron.matcher(nombre);
        return validacion.matches();
    }

}
