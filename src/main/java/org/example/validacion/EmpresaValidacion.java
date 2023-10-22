package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.maximoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;

public class EmpresaValidacion {

    public static Boolean validarNit(String nit)throws Exception{
        if(nit.length() != 10){
            throw new Exception(Mensaje.CARACTERESNIT.getMensaje());
        }
        return true;
    }

    public static Boolean validarNombre(String nombre) throws Exception {
        if (!maximoLetras(nombre, 30)) {
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (regExp(nombre,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

    public static Boolean validarDescripcion(String descripcion) throws Exception{
        if(!maximoLetras(descripcion,150)){
            throw new Exception(Mensaje.CANTIDADEXCESIVA.getMensaje());
        }else if (regExp(descripcion,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

}
