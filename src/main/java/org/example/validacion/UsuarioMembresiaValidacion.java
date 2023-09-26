package org.example.validacion;


import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.utilidades.Mensaje.TOPEPOSITIVO;

public class UsuarioMembresiaValidacion {

    public Boolean validarTopePago(Double pago) throws Exception{
        if(pago <= 0 ){
            throw new Exception(TOPENEGATIVO.getMensaje());
        }else if(pago > 100000){
            throw new Exception(TOPEPOSITIVO.getMensaje());
        }
        return true;
    }
}
