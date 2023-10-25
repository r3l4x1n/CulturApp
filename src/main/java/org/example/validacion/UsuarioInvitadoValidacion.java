package org.example.validacion;

import org.example.utilidades.Mensaje;

public class UsuarioInvitadoValidacion {

    public Boolean validarCedulaInvitado(String cedula)throws Exception{
        if (cedula == null || !cedula.matches("^[0-9]+$")) {
            throw new Exception(Mensaje.FORMATO_CEDULA.getMensaje());
        }
        if (!cedula.matches("\\d{10}")) {
            throw new Exception(Mensaje.LONGITUD_CEDULA.getMensaje());
        }

        return true;
    }
}
