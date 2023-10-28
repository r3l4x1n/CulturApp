package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.UsuarioValidacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.validacion.UsuarioValidacion.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para validar la clase UsuarioValidacion.
 */
class UsuarioValidacionTest {

    UsuarioValidacion usuarioValidacion;

    /**
     * Configura el entorno de prueba creando una instancia de UsuarioValidacion.
     */
    @BeforeEach
    void configurarPruebasUsuario() {
        System.out.println("Estoy ejecutando la prueba");
        this.usuarioValidacion = new UsuarioValidacion();
    }

    /**
     * Prueba que verifica la validación de un nombre por tener una cantidad insuficiente de letras.
     */
    @Test
    void validarNombrePorFallaNombreCorto() {
        Exception respuesta = assertThrows(Exception.class, () -> validarNombre("Santiago"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un nombre que contiene números.
     */
    @Test
    void validarNombrePorFallaPorNumerosEnNombre() {
        Exception respuesta = assertThrows(Exception.class, () -> validarNombre("Santiago1234"));
        assertEquals(Mensaje.CARACTERESNOMBRE.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un nombre correcto.
     */
    @Test
    void validarNombreCorrecto() {
        Boolean respuesta = assertDoesNotThrow(() -> validarNombre("Santiago Mosquera"));
        assertTrue(respuesta);
    }

    /**
     * Prueba que verifica la validación de un correo electrónico correcto.
     */
    @Test
    void validarCorreoCorrecto() {
        Boolean respuesta = assertDoesNotThrow(() -> validarCorreo("santiagomosquera@gmail.com"));
        assertTrue(respuesta);
    }

    /**
     * Prueba que verifica la validación de un correo electrónico incorrecto.
     */
    @Test
    void validarCorreoIncorrecto() {
        Exception respuesta = assertThrows(Exception.class, () -> validarCorreo("santiago@.c"));
        assertEquals(Mensaje.CARACTERESCORREO.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de una ubicación incorrecta (menor a 1).
     */
    @Test
    void validarUbicacionIncorrectaMenorUno() {
        Exception respuesta = assertThrows(Exception.class, () -> validarUbicacion("0"));
        assertEquals(Mensaje.NUMEROSVALIDOS.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de una ubicación incorrecta (mayor a 4).
     */
    @Test
    void validarUbicacionIncorrectaMayor4() {
        Exception respuesta = assertThrows(Exception.class, () -> validarUbicacion("5"));
        assertEquals(Mensaje.NUMEROSVALIDOS.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de una ubicación que contiene letras y caracteres especiales.
     */
    @Test
    void validarUbicacionConletrasYCaracteresEspeciales() {
        Exception respuesta = assertThrows(Exception.class, () -> validarUbicacion("G"));
        assertEquals(Mensaje.CARACTERESNUMERO.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de una ubicación válida.
     */
    @Test
    void validarUbicacionValida() {
        Integer respuesta = assertDoesNotThrow(() -> validarUbicacion("3"));
        assertEquals(3, 3);
    }

    /**
     * Prueba que verifica la validación de un documento nulo.
     */
    @Test
    public void validarDocumentoNull() {
        String cedulaPrueba = null;
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.usuarioValidacion.validarDocumento(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un formato incorrecto de documento de usuario.
     */
    @Test
    public void validarFormatoIncorrectoDocumentoUsuario() {
        String cedulaPrueba = "12345erd";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.usuarioValidacion.validarDocumento(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un documento de usuario con longitud larga.
     */
    @Test
    public void validarLongitudDocumentoLargo() {
        String cedulaPueba = "1234567890123";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.usuarioValidacion.validarDocumento(cedulaPueba));
        Assertions.assertEquals(Mensaje.LONGITUD_CEDULA.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un formato correcto de documento de usuario.
     */
    @Test
    public void validarFormatoCorrectoDocumentoUsuario() {
        String cedulaPrueba = "1234567890";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.usuarioValidacion.validarDocumento(cedulaPrueba));
        Assertions.assertTrue(respuesta);
    }
}