package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.ReservaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.example.validacion.ReservaValidacion.validarCantidadPersonas;
import static org.example.validacion.ReservaValidacion.validarFecha;
import static org.junit.jupiter.api.Assertions.*;

class ReservaValidacionTest {

    ReservaValidacion reservaValidacion;

    @BeforeEach
    void configurarPruebaReserva(){
        this.reservaValidacion = new ReservaValidacion();
    }

    @Test
    void validarFormatoFechaInvalida(){
        Exception resultado = assertThrows(Exception.class,()->validarFecha("2023/04/04"));

        assertEquals(Mensaje.FORMATOFECHA.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarFormatoFechaValida(){
        LocalDate resultado = assertDoesNotThrow(()->validarFecha("08/09/2023"));

        assertEquals("2023-09-08",resultado.toString());
    }
    @Test
    void validarCantidadDePersonasMenorUno(){
        Exception resultado = assertThrows(Exception.class,()->validarCantidadPersonas(0));
        assertEquals(Mensaje.CANPERRESERVA.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarCantidadDePersonasMayorCuatro() {
        Exception resultado = assertThrows(Exception.class, () -> validarCantidadPersonas(5));
        assertEquals(Mensaje.CANPERRESERVA.getMensaje(), resultado.getMessage());
    }

    @Test
    void validarCantidadCorrectaDePersonas(){
        Boolean resultado = assertDoesNotThrow(()->validarCantidadPersonas(3));
        assertTrue(resultado);
    }
}