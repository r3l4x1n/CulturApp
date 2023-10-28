package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.UsuarioValidacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.validacion.UsuarioValidacion.*;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioValidacionTest {



    UsuarioValidacion usuarioValidacion;


    @BeforeEach
    void configurarPruebasUsuario (){
        System.out.println("Estoy ejecutando la pruba");
        this.usuarioValidacion = new UsuarioValidacion();
    }

    @Test
    void validarNombrePorFallaNombreCorto() {

        Exception respuesta = assertThrows(Exception.class,()-> validarNombre("Santiago"));

        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(),respuesta.getMessage());
    }
    @Test
    void validarNombrePorFallaPorNumerosEnNombre(){
        Exception respuesta = assertThrows(Exception.class,()-> validarNombre("Santiago1234"));

        assertEquals(Mensaje.CARACTERESNOMBRE.getMensaje(),respuesta.getMessage());
    }
    @Test
    void validarNombreCorrecto(){
        Boolean respuesta = assertDoesNotThrow(()->validarNombre("Santiago Mosquera"));

        assertTrue(respuesta);
    }

    @Test
    void validarCorreoCorrecto(){
        Boolean respuesta = assertDoesNotThrow(()->validarCorreo("santiagomosquera@gmail.com"));

        assertTrue(respuesta);
    }

    @Test
    void validarCorreoIncorrecto(){
        Exception respuesta = assertThrows(Exception.class,()->validarCorreo("santiago@.c"));

        assertEquals(Mensaje.CARACTERESCORREO.getMensaje(),respuesta.getMessage());
    }

    @Test
    void validarUbicacionIncorrectaMenorUno(){
        Exception respuesta = assertThrows(Exception.class,()->validarUbicacion("0"));

        assertEquals(Mensaje.NUMEROSVALIDOS.getMensaje(),respuesta.getMessage());
    }

    @Test
    void validarUbicacionIncorrectaMayor4(){
        Exception respuesta = assertThrows(Exception.class,()->validarUbicacion("5"));

        assertEquals(Mensaje.NUMEROSVALIDOS.getMensaje(),respuesta.getMessage());
    }

    @Test
    void validarUbicacionConletrasYCaracteresEspeciales(){
        Exception respuesta = assertThrows(Exception.class,()->validarUbicacion("G"));

        assertEquals(Mensaje.CARACTERESNUMERO.getMensaje(),respuesta.getMessage());
    }

    @Test
    void validarUbicacionValida(){
        Integer respuesta = assertDoesNotThrow(()->validarUbicacion("3"));

        assertEquals(3,3);
    }

    @Test
    public void validarDocumentoNull(){
        String cedulaPrueba = null;
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.usuarioValidacion.validarDocumento(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }
    @Test
    public void validarFormatoIncorrectoDocumentoUsuario(){
        String cedulaPrueba = "12345erd";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.usuarioValidacion.validarDocumento(cedulaPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CEDULA.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarLongitudDocumentoLargo() {
        String cedulaPueba = "1234567890123";
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.usuarioValidacion.validarDocumento(cedulaPueba));
        Assertions.assertEquals(Mensaje.LONGITUD_CEDULA.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarFormatoCorrectoDocumentoUsuario(){
        String cedulaPrueba = "1234567890";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.usuarioValidacion.validarDocumento(cedulaPrueba));
        Assertions.assertTrue(respuesta);
    }

}