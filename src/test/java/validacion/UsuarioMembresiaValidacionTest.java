package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.UsuarioMembresiaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioMembresiaValidacionTest {

    UsuarioMembresiaValidacion usuarioMembresiaValidacion;

    @BeforeEach
    public void configurarPrueba(){
        this.usuarioMembresiaValidacion = new UsuarioMembresiaValidacion();
    }

    @Test
    public void validarPruebaSobrePasaTope(){
        Exception respuesta = assertThrows(Exception.class,()->usuarioMembresiaValidacion.validarTopePago(300000.0));
        assertEquals(Mensaje.TOPEPOSITIVO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarPruebaSobreInferiorTope(){
        Exception respuesta = assertThrows(Exception.class,()->usuarioMembresiaValidacion.validarTopePago(-0.0));
        assertEquals(Mensaje.TOPENEGATIVO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarPrubaFuncional(){
        Boolean respuesta = assertDoesNotThrow(()->usuarioMembresiaValidacion.validarTopePago(95000.0));
        assertTrue(respuesta);
    }

}