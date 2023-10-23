package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.minimoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;

public class EmpresaCulturalValidacion {

    public static Boolean validarNombreEmpresaCultural(String nombre)throws Exception{
        if(!minimoLetras(nombre,10)){
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        }else if(!regExp(nombre,"^[ a-zA-Z]+$")){
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }
    public Boolean validarCostoEmpresaCultural(Double costo)throws Exception{
        double costoBase = 1200000;
        double iva = 0.19;
        double descuento = 0.10;
        double cobroTotal = (costoBase + (costoBase * iva)) * (1 - descuento);

        if(costo > cobroTotal){
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        }else if(costo <= 0){
            throw new Exception(TOPENEGATIVO.getMensaje());
        }
        return true;
    }

}
