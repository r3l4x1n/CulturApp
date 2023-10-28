package org.example.validacion;

import org.example.utilidades.Mensaje;

import java.time.LocalDate;

public class UsuarioInvitadoValidacion {

    /**
     * Valida la cédula de un usuario invitado.
     *
     * @param cedula La cédula a validar, que debe ser una cadena de caracteres.
     * @return true si la cédula es válida, de lo contrario, se lanza una excepción.
     * @throws Exception Si la cédula no cumple con los requisitos de formato o longitud. La excepción contiene un mensaje de error específico.
     */
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
