package org.example.validacion;

import org.example.utilidades.Mensaje;

import java.time.LocalDate;

import static org.example.utilidades.Caracteres.maximoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Fecha.formatearFecha;

/**
 * Esta clase proporciona métodos para validar diferentes aspectos de una oferta.
 */
public class OfertaValidacion {

    /**
     * Valida el título de una oferta.
     *
     * @param titulo El título de la oferta a validar.
     * @return true si el título cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarTitulo(String titulo) throws Exception {
        if (!maximoLetras(titulo, 20)) {
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (regExp(titulo, "^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

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
     * Valida si la fecha de finalización de una oferta es válida.
     *
     * @param fechaInicio La fecha de inicio de la oferta.
     * @param fechaFin La fecha de finalización de la oferta.
     * @return true si la fecha de finalización es válida, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarFechaFinValida(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        if (fechaFin.isBefore(fechaInicio)) {
            throw new Exception(Mensaje.FECHAFINALVALIDA.getMensaje());
        }
        return true;
    }

    /**
     * Valida el costo por persona de una oferta.
     *
     * @param costo El costo por persona de la oferta a validar.
     * @return true si el costo es válido, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarCostoPersona(Double costo) throws Exception {
        if (costo <= 0) {
            throw new Exception(Mensaje.COSTOPERSONA.getMensaje());
        }
        return true;
    }
}
