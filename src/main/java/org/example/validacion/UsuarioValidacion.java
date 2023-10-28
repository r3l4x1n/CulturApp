package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.minimoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;

/**
 * Esta clase proporciona métodos para validar los campos de un usuario.
 */
public class UsuarioValidacion {

    /**
     * Valida el nombre de un usuario.
     *
     * @param nombre El nombre a validar.
     * @return true si el nombre cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarNombre(String nombre) throws Exception {
        if (!minimoLetras(nombre, 10)) {
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (!regExp(nombre, "^[ a-zA-Z]+$")) {
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }

    /**
     * Valida la ubicación de un usuario.
     *
     * @param ubicacion La ubicación a validar.
     * @return El valor numérico de la ubicación si cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Integer validarUbicacion(String ubicacion) throws Exception {
        if (!regExp(ubicacion, "^[0-9]+$")) {
            throw new Exception(Mensaje.CARACTERESNUMERO.getMensaje());
        }
        int ubicacionNum = Integer.parseInt(ubicacion);
        if (ubicacionNum < 1 || ubicacionNum > 4) {
            throw new Exception(Mensaje.NUMEROSVALIDOS.getMensaje());
        }
        return ubicacionNum;
    }

    /**
     * Valida la dirección de correo electrónico de un usuario.
     *
     * @param correo El correo electrónico a validar.
     * @return true si el correo electrónico cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarCorreo(String correo) throws Exception {
        if (!regExp(correo, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new Exception(Mensaje.CARACTERESCORREO.getMensaje());
        }
        return true;
    }

    /**
     * Valida el documento (por ejemplo, cédula) de un usuario.
     *
     * @param cedula El documento a validar.
     * @return true si el documento cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarDocumento(String cedula) throws Exception {
        if (cedula == null || !cedula.matches("^[0-9]+$")) {
            throw new Exception(Mensaje.FORMATO_CEDULA.getMensaje());
        }
        if (cedula.length() > 10 || cedula.length() < 5) {
            throw new Exception(Mensaje.LONGITUD_CEDULA.getMensaje());
        }
        return true;
    }
}
