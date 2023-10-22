package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.EmpresaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.validacion.EmpresaValidacion.*;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaValidacionTest {

    EmpresaValidacion empresaValidacion;

    @BeforeEach
    void configurarPruebaLocal(){
        this.empresaValidacion = new EmpresaValidacion();
    }

    @Test
    void validarNitMenorDiezDigitos(){
        Exception resultado = assertThrows(Exception.class,()->validarNit("aw12903"));
        assertEquals(Mensaje.CARACTERESNIT.getMensaje(),resultado.getMessage());
    }
    @Test
    void validarNitMayorDiezDigitos(){
        Exception resultado = assertThrows(Exception.class,()->validarNit("aw1dewedq34234324322903"));
        assertEquals(Mensaje.CARACTERESNIT.getMensaje(),resultado.getMessage());
    }
    @Test
    void validarNitValido(){
        Boolean resultado = assertDoesNotThrow(()->validarNit("123456789h"));
        assertTrue(resultado);
    }

    @Test
    void validarNombreConMasDeTreintaLetras(){
        Exception resultado = assertThrows(Exception.class,()->validarNombre("dewjdewiojdewijakJSKALsajKLSJAKLsA"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarNombreValido(){
        Boolean resultado = assertDoesNotThrow(()->validarNombre("Este es un nombre válido juhu!"));
        assertTrue(resultado);
    }

    @Test
    void validarDescricionConMasDeCientoCincuentaLetras(){
        Exception resultado = assertThrows(Exception.class,()->validarDescripcion("dewjdewiojdewijakJSKALsajKLSJAKLsA" +
                "dwldnkeldnkewdnklewndlkewndlewkdnlekndklewndlewkndlkwendklewndlewkndlkwendlenkd" +
                "lewkndekwldnewkldnlwekndlkwndlwkendlkwendlkewndklend4323432432"));
        assertEquals(Mensaje.CANTIDADEXCESIVA.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarDescripcionValida(){
        Boolean resultado = assertDoesNotThrow(()->validarDescripcion("Esta es una descripcion válidad" +
                "para comprobar la efectividad del metodo implementado y su correcto " +
                "funcionamiento"));
        assertTrue(resultado);
    }





}