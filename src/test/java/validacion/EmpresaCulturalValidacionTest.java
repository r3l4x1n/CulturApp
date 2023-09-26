package validacion;

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

}