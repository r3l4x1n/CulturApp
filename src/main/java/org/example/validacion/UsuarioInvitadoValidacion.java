package org.example.validacion;

import org.example.utilidades.Mensaje;

import java.time.LocalDate;

public class UsuarioInvitadoValidacion {

    public Boolean validarCedulaInvitado(String cedula)throws Exception{

        if (!cedula.matches("^[0-9]+$")) {
            throw new Exception(Mensaje.FORMATO_CEDULA.getMensaje());
        }
        if (cedula.length() > 10 ) {
            throw new Exception(Mensaje.LONGITUD_CEDULA.getMensaje());
        }
        return true;
    }
}
