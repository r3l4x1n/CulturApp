package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.EmpresaCulturalValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.validacion.EmpresaCulturalValidacion.validarNombreEmpresaCultural;
import static org.example.validacion.EmpresaPrivadaValidacion.validarNobreRepLegal;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaCulturalValidacionTest {

    EmpresaCulturalValidacion empresaCulturalValidacion;

    @BeforeEach
    public void prepararPrueba(){
        this.empresaCulturalValidacion = new EmpresaCulturalValidacion();
    }
    @Test
    public void validarNombreEmresaCulturalIncorrectoCaracteresMenor() {
        Exception respuesta = assertThrows(Exception.class,()-> validarNombreEmpresaCultural("Culapp"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(),respuesta.getMessage());
    }
    @Test
    public void validarNombreEmresaCulturalIncorrectoCaracteresMayor() {
        Exception respuesta = assertThrows(Exception.class,()-> validarNombreEmpresaCultural("culturapp2023"));
        assertEquals(Mensaje.CARACTERESNOMBRE.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarNombreCorrectoEmresaCultural() {
        Boolean respuesta = assertDoesNotThrow(()->validarNombreEmpresaCultural("CulturaApp"));
        assertTrue(respuesta);
    }

    @Test
    public void validar_costo_negativo(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural(0.0));
        assertEquals(TOPENEGATIVO.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validar_costo_superior(){
        Exception resultado = assertThrows(Exception.class,()->empresaCulturalValidacion.validarCostoEmpresaCultural(Double.valueOf(1285300)));
        assertEquals(COSTOSUPERIOREMPRESAS.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validar_costo_valido(){
        Boolean resultado = assertDoesNotThrow(()->empresaCulturalValidacion.validarCostoEmpresaCultural(Double.valueOf(1285200)));
        assertTrue(resultado);
    }

}