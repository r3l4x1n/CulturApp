package org.example.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {

    public static Boolean regExp(String nombre,String regExp){
        Pattern patron = Pattern.compile(regExp);
        Matcher validacion = patron.matcher(nombre);
        return validacion.matches();
    }

}
