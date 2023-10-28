package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.EmpresaCulturalValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.validacion.EmpresaCulturalValidacion.validarEMail;
import static org.example.validacion.EmpresaCulturalValidacion.validarNombreEmpresaCultural;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas para validar las validaciones de la clase EmpresaCulturalValidacion.
 */
public class EmpresaCulturalValidacionTest {

    EmpresaCulturalValidacion empresaCulturalValidacion;

    @BeforeEach
    public void prepararPrueba() {
        this.empresaCulturalValidacion = new EmpresaCulturalValidacion();
    }

    /**
     * Prueba para validar que el nombre de la empresa cultural tenga menos caracteres de lo esperado.
     */
    @Test
    public void validarNombreEmresaCulturalIncorrectoCaracteresMenor() {
        Exception respuesta = assertThrows(Exception.class, () -> validarNombreEmpresaCultural("Culapp"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba para validar que el nombre de la empresa cultural tenga más caracteres de lo esperado.
     */
    @Test
    public void validarNombreEmresaCulturalIncorrectoCaracteresMayor() {
        Exception respuesta = assertThrows(Exception.class, () -> validarNombreEmpresaCultural("culturapp2023"));
        assertEquals(Mensaje.CARACTERESNOMBRE.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba para validar un nombre de empresa cultural correcto.
     */
    @Test
    public void validarNombreCorrectoEmresaCultural() {
        Boolean respuesta = assertDoesNotThrow(() -> validarNombreEmpresaCultural("CulturApp"));
        assertTrue(respuesta);
    }

    /**
     * Prueba para validar un email correcto de la empresa cultural.
     */
    @Test
    void validacionEMailCorrecto(){
        Boolean respuesta = assertDoesNotThrow(()->validarEMail("culturapp@gmail.com"));
        assertTrue(respuesta);
    }

    /**
     * Prueba para validar un email incorrecto de la empresa cultural.
     */
    @Test
    void validarEMailIncorrecto(){
        Exception respuesta = assertThrows(Exception.class,()->validarEMail("culpp@.c"));
        assertEquals(Mensaje.CARACTERESCORREO.getMensaje(),respuesta.getMessage());
    }

    /**
     * Prueba para validar un costo de empresa cultural superior al límite.
     */
    @Test
    void validarCostoIncorrectoSuperior() {
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural1(1285300.0));
        assertEquals(Mensaje.COSTOSUPERIOREMPRESAS.getMensaje(),resultado.getMessage());
    }

    /**
     * Prueba para validar un costo de empresa cultural negativo.
     */
    @Test
    public void validarCostoIncorrectoNegativo() {
        Exception resultado = assertThrows(Exception.class, () ->empresaCulturalValidacion.validarCostoEmpresaCultural1(-0.0));
        assertEquals(Mensaje.TOPENEGATIVO.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba para validar un costo de empresa cultural válido.
     */
    @Test
    public void validarCostoCorrecto(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarCostoEmpresaCultural1(1285200.0));
        assertTrue(resultado);
    }

    /**
     * Prueba para validar una entidad con más de treinta letras.
     */
    @Test
    void validarEntidadConMasDeTreintaLetras(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarEntidad("dewjdewiojdewijakJSKALsajKLSJAKLsA" +
                "dwldnkeldnk4354332432"));
        assertEquals(Mensaje.CANTIDADEXCESIVA.getMensaje(),resultado.getMessage());
    }

    /**
     * Prueba para validar una entidad válida.
     */
    @Test
    void validarEntidadValida(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarEntidad("Esta es es una entidad valida"));
        assertTrue(resultado);
    }

    /**
     * Prueba para validar una misión con más de 150 letras.
     */
    @Test
    void validarMisionConMas150DeLetras(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarMision("dewjdewiojdewijakJSKALsajKLSJAKLsA" +
                "dwldnkeldnk435dwqoidjwiodjioewjiowd9832yr839y892ehd3289hd892hd829hd38h329hd832d8h928d329hd3" +
                "dbui2bd2eudbe2uidbe2ibdeidue2biu2bdie2bdiu2ebdiu2ebdui2ebd4332432"));
        assertEquals(Mensaje.CANTIDADEXCESIVA.getMensaje(),resultado.getMessage());
    }

    /**
     * Prueba para validar una misión válida.
     */
    @Test
    void validarMisionValida(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarMision("Esta es una mision validad" +
                "para comprobar que el metodo implementado funciona adecuadamente"));
        assertTrue(resultado);
    }

    /**
     * Prueba para validar un costo de empresa cultural negativo.
     */
    @Test
    public void validar_costo_negativo(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural(0.0));
        assertEquals(TOPENEGATIVO.getMensaje(),resultado.getMessage());
    }

    /**
     * Prueba para validar un costo de empresa cultural superior al límite.
     */
    @Test
    public void validar_costo_superior(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural(125.000));
        assertEquals(COSTOSUPERIOREMPRESAS.getMensaje(),resultado.getMessage());
    }

    /**
     * Prueba para validar un costo de empresa cultural válido.
     */
    @Test
    public void validar_costo_valido(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarCostoEmpresaCultural(100.000));
        assertTrue(resultado);
    }

}