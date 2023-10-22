package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.EmpresaCulturalValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaCulturalValidacionTest {

    EmpresaCulturalValidacion empresaCulturalValidacion;

    @BeforeEach
    public void prepararPrueba(){
        this.empresaCulturalValidacion = new EmpresaCulturalValidacion();
    }

    @Test
    public void validar_costo_negativo(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural(0.0));
        assertEquals(TOPENEGATIVO.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validar_costo_superior(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural(125.000));
        assertEquals(COSTOSUPERIOREMPRESAS.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validar_costo_valido(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarCostoEmpresaCultural(100.000));
        assertTrue(resultado);
    }

    @Test
    void validarEntidadConMasDeTreintaLetras(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarEntidad("dewjdewiojdewijakJSKALsajKLSJAKLsA" +
                "dwldnkeldnk4354332432"));
        assertEquals(Mensaje.CANTIDADEXCESIVA.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarEntidadValida(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarEntidad("Esta es es una entidad valida"));
        assertTrue(resultado);
    }

    @Test
    void validarMisionConMas150DeLetras(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarMision("dewjdewiojdewijakJSKALsajKLSJAKLsA" +
                "dwldnkeldnk435dwqoidjwiodjioewjiowd9832yr839y892ehd3289hd892hd829hd38h329hd832d8h928d329hd3" +
                "dbui2bd2eudbe2uidbe2ibdeidue2biu2bdie2bdiu2ebdiu2ebdui2ebd4332432"));
        assertEquals(Mensaje.CANTIDADEXCESIVA.getMensaje(),resultado.getMessage());
    }

    @Test
    void validarMisionValida(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarMision("Esta es una mision validad" +
                        "para comprobar que el metodo implementado funciona adecuadamente"));
        assertTrue(resultado);
    }

}