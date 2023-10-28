package org.example.utilidades;

/**
 * Este enum proporciona mensajes de error o información que pueden ser utilizados en una aplicación para comunicar situaciones específicas al usuario.
 */
public enum Mensaje {
    CANTIDADLETRAS("Digite la cantidad de caracteres requidas"),
    CANTIDADEXCESIVA("La cantidad de caracteres es excesiva"),
    CARACTERESNOMBRE("El nombre no puede contener numeros ni caracteres especiales"),
    CARACTERESNUMERO("La ubicacion no puede contener letras"),
    NUMEROSVALIDOS("La direccion debe estar entre los numeros 1 y 4"),
    CARACTERESCORREO("El correo electrónico debe ser un correo válido"),
    CARACTERESNIT("El campo nit debe contener 10 digitos"),
    FORMATOFECHA("Ingrese un formato de fecha válido"),
    FECHAFINALVALIDA("La fecha del final del evento no puede ser menor a la fecha de inicio"),
    COSTOPERSONA("El costo por persona no puede ser negaivo"),
    CANPERRESERVA("El numero de personas por reserva no puede ser mayor a 4 o menor que 0"),
    TOPENEGATIVO("El valor no puede ser negativo"),
    TOPEPOSITIVO("El valor del pago no puede superar los 100.000 pesos"),

    COSTOSUPERIOREMPRESAS("El costo no puede superar los 220.000 pesos"),

    FORMATO_CEDULA ("El formato de la cedula no es valido"),

    LONGITUD_CEDULA ("La longitud de la cedula no puede ser mayor a 10"),
    CAMPOREQUERIDO ("Debes ingresar la cedula, el campo no puede ir vacio");

    /**
     * Obtiene el mensaje asociado al valor enum.
     *
     * @return El mensaje asociado al valor enum.
     */
    public String mensaje;

    /**
     * Establece un mensaje personalizado para el valor enum.
     *
     * @param mensaje El mensaje personalizado a establecer.
     */
    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
