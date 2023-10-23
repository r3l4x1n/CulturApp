package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.EmpresaPrivadaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.validacion.EmpresaPrivadaValidacion.validarCedulaRepLegal;
import static org.example.validacion.EmpresaPrivadaValidacion.validarNobreRepLegal;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaPrivadaValidacionTest {

    EmpresaPrivadaValidacion empresaPrivadaValidacion;

    @BeforeEach
    public void prepararPrueba(){
        this.empresaPrivadaValidacion = new EmpresaPrivadaValidacion();
    }

    @Test

    public void validarNombreIncorrectoNombreCorto() {
        Exception respuesta = assertThrows(Exception.class,()-> validarNobreRepLegal("Gus@"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarNombreIncorrectoCaracteres() {
        Exception respuesta = assertThrows(Exception.class,()-> validarNobreRepLegal("GustavoCardona10"));
        assertEquals(Mensaje.CARACTERESNOMBRE.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarNombreCorrecto() {
        Boolean respuesta = assertDoesNotThrow(()->validarNobreRepLegal("Gustavo Cardona"));
        assertTrue(respuesta);
    }

    @Test
    public void validarCedulaRepLegalIncorrectoNumeroMenorCaracteres() {
        Exception resultado = assertThrows(Exception.class, ()-> validarCedulaRepLegal("23adfasd"));
        assertEquals(Mensaje.CARACTERESCEDULA.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validarCedulaRepresentanteLegalNumeroMayorCaracteres() {
        Exception resultado = assertThrows(Exception.class, ()-> validarCedulaRepLegal("sdfgsdfg634564524"));
        assertEquals(Mensaje.CARACTERESCEDULA.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validacionCedulaCorrecta() {
        Boolean resultado = assertDoesNotThrow(()-> validarCedulaRepLegal("1234567890"));
        assertTrue(resultado);
    }
    @Test
    public void costo_empresa_negativo(){
        Exception resultado = assertThrows(Exception.class,()->empresaPrivadaValidacion.validarCostoEmpresaPrivada(-0.0));
        assertEquals(TOPENEGATIVO.getMensaje(),resultado.getMessage());
    }
    @Test
    public void costo_empresa_superior(){
        Exception resultado = assertThrows(Exception.class,()->empresaPrivadaValidacion.validarCostoEmpresaPrivada(Double.valueOf(2619000)));
        assertEquals(COSTOSUPERIOREMPRESAS.getMensaje(),resultado.getMessage());
    }

    @Test
    public void costo_empresa_valido(){
        Boolean resultado = assertDoesNotThrow(()->empresaPrivadaValidacion.validarCostoEmpresaPrivada(Double.valueOf(2618000)));
        assertTrue(resultado);
    }
}