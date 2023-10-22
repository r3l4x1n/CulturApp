package org.example.utilidades;

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
    COSTOSUPERIOREMPRESAS("El costo no puede superar los 220.000 pesos");
    public String mensaje;

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
