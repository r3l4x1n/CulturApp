package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.OfertaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.example.validacion.OfertaValidacion.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para validar la clase OfertaValidacion.
 */
class OfertaValidacionTest {

    OfertaValidacion ofertaValidacion;

    /**
     * Configura el entorno de prueba creando una instancia de OfertaValidacion.
     */
    @BeforeEach
    void configurarPruebaOferta() {
        this.ofertaValidacion = new OfertaValidacion();
    }

    /**
     * Prueba que verifica la validación de un título con más de veinte letras.
     */
    @Test
    void validarTituloConMasDeVeinteLetras() {
        Exception resultado = assertThrows(Exception.class, () -> validarTitulo("oweidjoewdjieodijewodjioewdjiweo"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de un título válido.
     */
    @Test
    void validarTituloValido() {
        Boolean resultado = assertDoesNotThrow(() -> validarTitulo("Los perritos"));
        assertTrue(resultado);
    }

    /**
     * Prueba que verifica la validación de un formato de fecha erróneo.
     */
    @Test
    void validarFormatoFechaErrado() {
        Exception resultado = assertThrows(Exception.class, () -> validarFecha("2023/08/09"));
        assertEquals(Mensaje.FORMATOFECHA.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de un formato de fecha válido.
     */
    @Test
    void validarFormatoFechaValido() {
        LocalDate resultado = assertDoesNotThrow(() -> validarFecha("08/09/2023"));
        assertEquals("2023-09-08", resultado.toString());
    }

    /**
     * Prueba que verifica la validación de una fecha de fin válida.
     */
    @Test
    void validarFechaFinValdia() {
        LocalDate fechaInicio = LocalDate.of(2023, 8, 1);
        LocalDate fechaFin = LocalDate.of(2023, 8, 15);
        Boolean resultado = assertDoesNotThrow(() -> validarFechaFinValida(fechaInicio, fechaFin));
        assertTrue(resultado);
    }

    /**
     * Prueba que verifica la validación de una fecha de fin inválida.
     */
    @Test
    void validarFechaFinInvalida() {
        LocalDate fechaInicio = LocalDate.of(2023, 8, 15);
        LocalDate fechaFin = LocalDate.of(2023, 8, 1);
        Exception resultado = assertThrows(Exception.class, () -> validarFechaFinValida(fechaInicio, fechaFin));
        assertEquals(Mensaje.FECHAFINALVALIDA.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de un costo por persona inválido.
     */
    @Test
    void validarCostoPersonaInvalido() {
        Exception resultado = assertThrows(Exception.class, () -> validarCostoPersona(0.0));
        assertEquals(Mensaje.COSTOPERSONA.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de un costo por persona válido.
     */
    @Test
    void validarCostoPersonaValido() {
        Boolean resultado = assertDoesNotThrow(() -> validarCostoPersona(12.000));
        assertTrue(resultado);
    }
}


