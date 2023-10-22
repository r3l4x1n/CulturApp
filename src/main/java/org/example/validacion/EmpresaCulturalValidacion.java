package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.maximoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;

public class EmpresaCulturalValidacion {

    public Boolean validarCostoEmpresaCultural(Double costo)throws Exception{

        if(costo > 120.000){
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        }else if(costo <= 0){
            throw new Exception(TOPENEGATIVO.getMensaje());
        }
        return true;
    }

    public Boolean validarEntidad(String entidad) throws Exception{
        if(!maximoLetras(entidad,30)){
            throw new Exception(Mensaje.CANTIDADEXCESIVA.getMensaje());
        }else if (regExp(entidad,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }


    public Boolean validarMision(String mision) throws Exception{
        if(!maximoLetras(mision,150)){
            throw new Exception(Mensaje.CANTIDADEXCESIVA.getMensaje());
        }else if (regExp(mision,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }
}
