package validacion;

import org.example.validacion.UsuarioPagoXEventoValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.utilidades.Mensaje.TOPEPOSITIVO;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioPagoXEventoValidacionTest {

    UsuarioPagoXEventoValidacion usuarioPagoXEventoValidacion;

    @BeforeEach
    public void prepararPrueba(){
        this.usuarioPagoXEventoValidacion = new UsuarioPagoXEventoValidacion();
    }

    @Test
    public void validar_costo_negativo(){
        Exception resultado = assertThrows(Exception.class,()->usuarioPagoXEventoValidacion.validarTopePago(-0.0));
        assertEquals(TOPENEGATIVO.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validar_costo_elevado(){
        Exception resultado = assertThrows(Exception.class,()->usuarioPagoXEventoValidacion.validarTopePago(201.000));
        assertEquals(TOPEPOSITIVO.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validar_costo_valido(){
        Boolean resultado = assertDoesNotThrow(()->usuarioPagoXEventoValidacion.validarTopePago(150.000));
        assertTrue(resultado);
    }

}