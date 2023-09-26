package validacion;

import org.example.validacion.EmpresaPrivadaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaPrivadaValidacionTest {

    EmpresaPrivadaValidacion empresaPrivadaValidacion;

    @BeforeEach
    public void prepararPrueba(){
        this.empresaPrivadaValidacion = new EmpresaPrivadaValidacion();
    }

    @Test
    public void costo_empresa_negativo(){
        Exception resultado = assertThrows(Exception.class,()->empresaPrivadaValidacion.validarCostoEmpresaPrivada(-0.0));
        assertEquals(TOPENEGATIVO.getMensaje(),resultado.getMessage());
    }

    @Test
    public void costo_empresa_superior(){
        Exception resultado = assertThrows(Exception.class,()->empresaPrivadaValidacion.validarCostoEmpresaPrivada(222.000));
        assertEquals(COSTOSUPERIOREMPRESAS.getMensaje(),resultado.getMessage());
    }

    @Test
    public void costo_empresa_valido(){
        Boolean resultado = assertDoesNotThrow(()->empresaPrivadaValidacion.validarCostoEmpresaPrivada(180.000));
        assertTrue(resultado);
    }
}