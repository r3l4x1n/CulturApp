package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.maximoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;

/**
 * Esta clase proporciona métodos para validar diferentes aspectos de una empresa.
 */
public class EmpresaValidacion {

    /**
     * Valida el NIT de la empresa.
     *
     * @param nit El NIT de la empresa a validar.
     * @return true si el NIT cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarNit(String nit) throws Exception {
        if (nit == null || !nit.matches("^[0-9]+$")) {
            throw new Exception(Mensaje.CARACTERESNIT.getMensaje());
        }
        if (!nit.matches("\\d{10}")) {
            throw new Exception(Mensaje.CARACTERESNIT.getMensaje());
        }
        return true;
    }
    /**
     * Valida el nombre de la empresa.
     *
     * @param nombre El nombre de la empresa a validar.
     * @return true si el nombre cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarNombre(String nombre) throws Exception {
        if (!maximoLetras(nombre, 30)) {
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (regExp(nombre, ".*[0-9!@#$%^&*()].*")) {
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }
    /*
    public static Boolean validarNit(String nit)throws Exception{
        if(nit.length() != 10){
            throw new Exception(Mensaje.CARACTERESNIT.getMensaje());
        }
        return true;
    }

     */

    /**
     * Valida la descripción de la empresa.
     *
     * @param descripcion La descripción de la empresa a validar.
     * @return true si la descripción cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarDescripcion(String descripcion) throws Exception{
        if(!maximoLetras(descripcion,150)){
            throw new Exception(Mensaje.CANTIDADEXCESIVA.getMensaje());
        }else if (regExp(descripcion,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

/*
    public static Boolean validarNombre(String nombre) throws Exception {
        if (!maximoLetras(nombre, 30)) {
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (regExp(nombre,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

 */


}
