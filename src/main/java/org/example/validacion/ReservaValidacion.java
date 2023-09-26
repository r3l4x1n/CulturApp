package org.example.validacion;

import org.example.utilidades.Mensaje;

import java.time.LocalDate;

import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Fecha.formatearFecha;

public class ReservaValidacion {

    public static LocalDate validarFecha(String fecha)throws Exception{
        if(!regExp(fecha,"^[0-3][0-9]+/[0-1][0-9]+/[2][0][2-9][0-9]$")){
            throw new Exception(Mensaje.FORMATOFECHA.getMensaje());
        }
        LocalDate nuevaFecha = formatearFecha(fecha);
        return nuevaFecha;
    }

    public static Boolean validarCantidadPersonas(Integer cantidadPersonas) throws Exception{
        if(cantidadPersonas <= 0 || cantidadPersonas > 4){
            throw new Exception(Mensaje.CANPERRESERVA.getMensaje());
        }
        return true;

    }


}
