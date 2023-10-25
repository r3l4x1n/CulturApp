package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.UsuarioInvitadoValidacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioInvitadoValidacionTest {

    UsuarioInvitadoValidacion usuarioInvitadoValidacion;

    @BeforeEach
    public void configurarPruebasIniciales(){
        System.out.println("EStoy ejecutando la prueba");
        this.usuarioInvitadoValidacion = new UsuarioInvitadoValidacion();
    }

    @Test
    public void validarCedulaNull(){
        String cedulaPrueba = null;
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }
    @Test
    public void validarFormatoIncorrectoCedulaReferido(){
        String cedulaPrueba = "12345erd";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarLongitudCedulaLarga() {
        String cedulaPueba = "1234567890123";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPueba));
        Assertions.assertEquals(Mensaje.LONGITUD_CEDULA.getMensaje(), respuesta.getMessage());
    }



    @Test
    public void validarFormatoCorrectoCedulaReferido(){
        String cedulaPrueba = "1234567890";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaPrueba));
        Assertions.assertTrue(respuesta);
    }
}