package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.minimoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;

public class UsuarioValidacion {
    public static Boolean validarNombre(String nombre)throws Exception{
        if(!minimoLetras(nombre,10)){
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        }else if(!regExp(nombre,"^[ a-zA-Z]+$")){
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }

    public static Integer validarUbicacion(String ubicacion)throws Exception{
        if(!regExp(ubicacion,"^[0-9]+$")){
            throw new Exception(Mensaje.CARACTERESNUMERO.getMensaje());
        }
        if(Integer.parseInt(ubicacion) < 1 || Integer.parseInt(ubicacion) > 4){
            throw new Exception(Mensaje.NUMEROSVALIDOS.getMensaje());
        }

        return Integer.parseInt(ubicacion);
    }

    public static Boolean validarCorreo(String correo)throws Exception{
        if(!regExp(correo,"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new Exception(Mensaje.CARACTERESCORREO.getMensaje());
        }
        return true;
    }

    public static Boolean validarDocumento(String cedula)throws Exception{
        if (cedula == null || !cedula.matches("^[0-9]+$")) {
            throw new Exception(Mensaje.FORMATO_CEDULA.getMensaje());
        }
        if (cedula.length() > 10 || cedula.length() < 5 ) {
            throw new Exception(Mensaje.LONGITUD_CEDULA.getMensaje());
        }

        return true;

    }

}
