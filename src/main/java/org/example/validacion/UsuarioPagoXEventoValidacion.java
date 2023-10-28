package org.example.validacion;

import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.utilidades.Mensaje.TOPEPOSITIVO;

/**
 * Esta clase proporciona un método para validar el tope de pago de un usuario por evento.
 */
public class UsuarioPagoXEventoValidacion {

    /**
     * Valida el tope de pago de un usuario por evento.
     *
     * @param pago El monto de pago a validar.
     * @return true si el monto de pago cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public Boolean validarTopePago(Double pago) throws Exception {
        if (pago <= 0) {
            throw new Exception(TOPENEGATIVO.getMensaje());
        } else if (pago > 200000) {
            throw new Exception(TOPEPOSITIVO.getMensaje());
        }
        return true;
    }
}
