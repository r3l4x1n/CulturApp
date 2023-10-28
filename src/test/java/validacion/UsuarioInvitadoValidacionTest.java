package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.UsuarioInvitadoValidacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para validar la clase UsuarioInvitadoValidacion.
 */
class UsuarioInvitadoValidacionTest {

    UsuarioInvitadoValidacion usuarioInvitadoValidacion;

    /**
     * Configura el entorno de prueba creando una instancia de UsuarioInvitadoValidacion.
     */
    @BeforeEach
    public void configurarPruebasIniciales() {
        System.out.println("Estoy ejecutando la prueba");
        this.usuarioInvitadoValidacion = new UsuarioInvitadoValidacion();
    }

    /**
     * Prueba que verifica la validación de un formato incorrecto de cédula de referido.
     */
    @Test
    public void validarFormatoIncorrectoCedulaReferido() {
        String cedulaPrueba = "12345erd";
        Exception respuesta = Assertions.assertThrows(Exception.class, () ->
                this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de una cédula de referido con longitud larga.
     */
    @Test
    public void validarLongitudCedulaLarga() {
        String cedulaPrueba = "1234567890123";
        Exception respuesta = Assertions.assertThrows(Exception.class, () ->
                this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPrueba));
        Assertions.assertEquals(Mensaje.LONGITUD_CEDULA.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un formato correcto de cédula de referido.
     */
    @Test
    public void validarFormatoCorrectoCedulaReferido() {
        String cedulaPrueba = "1234567890";
        Boolean respuesta = Assertions.assertDoesNotThrow(() ->
                this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPrueba));
        Assertions.assertTrue(respuesta);
    }
}