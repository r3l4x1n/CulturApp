package org.example.validacion;

import org.example.utilidades.Mensaje;

import java.time.LocalDate;

import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Fecha.formatearFecha;

/**
 * Esta clase proporciona métodos para validar diferentes aspectos de una reserva.
 */
public class ReservaValidacion {

    /**
     * Valida una fecha en formato dd/MM/yyyy.
     *
     * @param fecha La fecha a validar en formato dd/MM/yyyy.
     * @return La fecha en formato LocalDate si cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static LocalDate validarFecha(String fecha) throws Exception {
        if (!regExp(fecha, "^[0-3][0-9]+/[0-1][0-9]+/[2][0][2-9][0-9]$")) {
            throw new Exception(Mensaje.FORMATOFECHA.getMensaje());
        }
        LocalDate nuevaFecha = formatearFecha(fecha);
        return nuevaFecha;
    }

    /**
     * Valida la cantidad de personas en una reserva.
     *
     * @param cantidadPersonas La cantidad de personas en la reserva a validar.
     * @return true si la cantidad de personas es válida, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarCantidadPersonas(Integer cantidadPersonas) throws Exception {
        if (cantidadPersonas <= 0 || cantidadPersonas > 4) {
            throw new Exception(Mensaje.CANPERRESERVA.getMensaje());
        }
        return true;
    }
}
