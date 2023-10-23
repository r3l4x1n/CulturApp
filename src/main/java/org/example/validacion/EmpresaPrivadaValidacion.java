package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.minimoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;

public class EmpresaPrivadaValidacion {

    public static Boolean validarNobreRepLegal(String nombre)throws Exception{
        if(!minimoLetras(nombre,10)){
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        }else if(!regExp(nombre,"^[ a-zA-Z]+$")){
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }

    public Boolean validarCostoEmpresaPrivada(Double costo) throws Exception{
        double costoBase = 2200000;
        double iva = 0.19;
        double cobroTotal = costoBase * (1 + iva);

        if(costo > cobroTotal){
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        } else if (costo <= 0) {
            throw new Exception(TOPENEGATIVO.getMensaje());
        }
        return true;
    }

    public static Boolean validarCedulaRepLegal(String nit)throws Exception{
        if(nit.length() != 10){
            throw new Exception(Mensaje.CARACTERESCEDULA.getMensaje());
        }
        return true;
    }
}
