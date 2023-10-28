package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.UsuarioMembresiaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para validar la clase UsuarioMembresiaValidacion.
 */
class UsuarioMembresiaValidacionTest {

    UsuarioMembresiaValidacion usuarioMembresiaValidacion;

    /**
     * Configura el entorno de prueba creando una instancia de UsuarioMembresiaValidacion.
     */
    @BeforeEach
    public void configurarPrueba() {
        this.usuarioMembresiaValidacion = new UsuarioMembresiaValidacion();
    }

    /**
     * Prueba que verifica la validación de un tope de pago que sobrepasa el límite.
     */
    @Test
    public void validarPruebaSobrePasaTope() {
        Exception respuesta = assertThrows(Exception.class, () ->
                usuarioMembresiaValidacion.validarTopePago(300000.0));
        assertEquals(Mensaje.TOPEPOSITIVO.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un tope de pago que es inferior al límite.
     */
    @Test
    public void validarPruebaSobreInferiorTope() {
        Exception respuesta = assertThrows(Exception.class, () ->
                usuarioMembresiaValidacion.validarTopePago(-0.0));
        assertEquals(Mensaje.TOPENEGATIVO.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba funcional que verifica la validación de un tope de pago dentro del límite permitido.
     */
    @Test
    public void validarPrubaFuncional() {
        Boolean respuesta = assertDoesNotThrow(() -> usuarioMembresiaValidacion.validarTopePago(95000.0));
        assertTrue(respuesta);
    }
}