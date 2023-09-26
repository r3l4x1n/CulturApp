package org.example.validacion;

import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;

public class EmpresaPrivadaValidacion {

    public Boolean validarCostoEmpresaPrivada(Double costo) throws Exception{
        if(costo > 220.000){
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        } else if (costo <= 0) {
            throw new Exception(TOPENEGATIVO.getMensaje());
        }
        return true;
    }
}
