package validacion;

import org.example.validacion.UsuarioPagoXEventoValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.utilidades.Mensaje.TOPEPOSITIVO;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para validar la clase UsuarioPagoXEventoValidacion.
 */
class UsuarioPagoXEventoValidacionTest {

    UsuarioPagoXEventoValidacion usuarioPagoXEventoValidacion;

    /**
     * Configura el entorno de prueba creando una instancia de UsuarioPagoXEventoValidacion.
     */
    @BeforeEach
    public void prepararPrueba() {
        this.usuarioPagoXEventoValidacion = new UsuarioPagoXEventoValidacion();
    }

    /**
     * Prueba que verifica la validación de un costo negativo.
     */
    @Test
    public void validar_costo_negativo() {
        Exception resultado = assertThrows(Exception.class, () ->
                usuarioPagoXEventoValidacion.validarTopePago(-0.0));
        assertEquals(TOPENEGATIVO.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de un costo elevado.
     */
    @Test
    public void validar_costo_elevado() {
        Exception resultado = assertThrows(Exception.class, () ->
                usuarioPagoXEventoValidacion.validarTopePago(201000.0));
        assertEquals(TOPEPOSITIVO.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de un costo válido.
     */
    @Test
    public void validar_costo_valido() {
        Boolean resultado = assertDoesNotThrow(() ->
                usuarioPagoXEventoValidacion.validarTopePago(150000.0));
        assertTrue(resultado);
    }
}