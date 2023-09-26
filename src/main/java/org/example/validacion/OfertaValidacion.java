package org.example.validacion;

import org.example.utilidades.Mensaje;

import java.time.LocalDate;

import static org.example.utilidades.Caracteres.maximoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Fecha.formatearFecha;

public class OfertaValidacion {

    public static Boolean validarTitulo(String titulo) throws Exception{

        if(!maximoLetras(titulo,20)){
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (regExp(titulo,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

    public static LocalDate validarFecha(String fecha)throws Exception{
        if(!regExp(fecha,"^[0-3][0-9]+/[0-1][0-9]+/[2][0][2-9][0-9]$")){
            throw new Exception(Mensaje.FORMATOFECHA.getMensaje());
        }
        LocalDate nuevaFecha = formatearFecha(fecha);
        return nuevaFecha;
    }

    public static Boolean validarFechaFinValida(LocalDate fechaInicio,LocalDate fechaFin) throws Exception{
        if(fechaFin.isBefore(fechaInicio)){
            throw new Exception(Mensaje.FECHAFINALVALIDA.getMensaje());
        }
        return true;
    }

    public static Boolean validarCostoPersona (Double costo) throws Exception{
        if(costo <= 0){
            throw new Exception(Mensaje.COSTOPERSONA.getMensaje());
        }
        return true;
    }




}
