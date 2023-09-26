package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.OfertaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.example.validacion.OfertaValidacion.*;
import static org.junit.jupiter.api.Assertions.*;

class OfertaValidacionTest {

    OfertaValidacion ofertaValidacion;

    @BeforeEach
    void configurarPruebaOferta(){
        this.ofertaValidacion = new OfertaValidacion();
    }

    @Test
    void validarTituloConMasDeVeinteLetras(){
        Exception resultado = assertThrows(Exception.class,()->validarTitulo("oweidjoewdjieodijewodjioewdjiweo"));

        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarTituloValido(){
        Boolean resultado = assertDoesNotThrow(()->validarTitulo("Los perritos"));
        assertTrue(resultado);
    }

    @Test
    void validarFormatoFechaErrado(){
        Exception resultado = assertThrows(Exception.class,()->validarFecha("2023/08/09"));
        assertEquals(Mensaje.FORMATOFECHA.getMensaje(),resultado.getMessage());
    }
    @Test
    void validarFormatoFechaValido(){
        LocalDate resultado = assertDoesNotThrow(()->validarFecha("08/09/2023"));
        assertEquals("2023-09-08",resultado.toString());
    }

    @Test
    void validarFechaFinValdia(){
        LocalDate fechaInicio = LocalDate.of(2023, 8, 1);
        LocalDate fechaFin = LocalDate.of(2023, 8, 15);
        Boolean resultado = assertDoesNotThrow(()->validarFechaFinValida(fechaInicio,fechaFin));
        assertTrue(resultado);
    }

    @Test
    void validarFechaFinInvalida(){
        LocalDate fechaInicio = LocalDate.of(2023, 8, 15);
        LocalDate fechaFin = LocalDate.of(2023, 8, 1);
        Exception resultado = assertThrows(Exception.class,()->validarFechaFinValida(fechaInicio,fechaFin));
        assertEquals(Mensaje.FECHAFINALVALIDA.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarCostoPersonaInvalido(){
        Exception resultado = assertThrows(Exception.class,()->validarCostoPersona(0.0));
        assertEquals(Mensaje.COSTOPERSONA.getMensaje(),resultado.getMessage());
    }
    @Test
    void validarCostoPersonaValido(){
        Boolean resultado = assertDoesNotThrow(()->validarCostoPersona(12.000));
        assertTrue(resultado);
    }


    }


