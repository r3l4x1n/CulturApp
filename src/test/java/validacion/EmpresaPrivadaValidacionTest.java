package validacion;

import org.example.utilidades.Mensaje;
import org.example.validacion.EmpresaPrivadaValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;
import static org.example.validacion.EmpresaPrivadaValidacion.validarCedulaRepLegal;
import static org.example.validacion.EmpresaPrivadaValidacion.validarNombreRepLegal;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para validar la clase EmpresaPrivadaValidacion.
 */
public class EmpresaPrivadaValidacionTest {

    EmpresaPrivadaValidacion empresaPrivadaValidacion;

    /**
     * Preparar el entorno de prueba creando una instancia de EmpresaPrivadaValidacion.
     */
    @BeforeEach
    public void prepararPrueba() {
        this.empresaPrivadaValidacion = new EmpresaPrivadaValidacion();
    }

    /**
     * Prueba que verifica el manejo de un costo de empresa negativo.
     */
    @Test
    public void costo_empresa_negativo() {
        Exception resultado = assertThrows(Exception.class, () -> empresaPrivadaValidacion.validarCostoEmpresaPrivada(-0.0));
        assertEquals(TOPENEGATIVO.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica el manejo de un costo de empresa superior al límite.
     */
    @Test
    public void costo_empresa_superior() {
        Exception resultado = assertThrows(Exception.class, () -> empresaPrivadaValidacion.validarCostoEmpresaPrivada(222.000));
        assertEquals(COSTOSUPERIOREMPRESAS.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica el manejo de un costo de empresa válido.
     */
    @Test
    public void costo_empresa_valido() {
        Boolean resultado = assertDoesNotThrow(() -> empresaPrivadaValidacion.validarCostoEmpresaPrivada(180.000));
        assertTrue(resultado);
    }

    /**
     * Prueba que verifica la validación de un nombre de representante legal con un nombre corto.
     */
    @Test
    void validarNombreRepLegalPorFallaNombreCorto() {
        Exception respuesta = assertThrows(Exception.class, () -> validarNombreRepLegal("Gus"));
        assertEquals(Mensaje.CANTIDADLETRAS.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un nombre de representante legal con números en el nombre.
     */
    @Test
    void validarNombreRepLegalFallaPorNumerosEnNombre() {
        Exception respuesta = assertThrows(Exception.class, () -> validarNombreRepLegal("cardona231234"));
        assertEquals(Mensaje.CARACTERESNOMBRE.getMensaje(), respuesta.getMessage());
    }

    /**
     * Prueba que verifica la validación de un nombre de representante legal válido.
     */
    @Test
    void validarNombreCorrectovalidarNombreRepLegal() {
        Boolean respuesta = assertDoesNotThrow(() -> validarNombreRepLegal("Gustavo Cardona"));
        assertTrue(respuesta);
    }

    /**
     * Prueba que verifica la validación de una cédula de representante legal nula.
     */
    @Test
    public void ValidarCedulaRepLegalCedulaNula() {
        Exception resultado = assertThrows(Exception.class, () -> validarCedulaRepLegal(null));
        assertEquals(Mensaje.CAMPOREQUERIDO.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de una cédula de representante legal no numérica.
     */
    @Test
    public void ValidarCedulaRepLegalCedulaNoNumerica() {
        Exception resultado = assertThrows(Exception.class, () -> validarCedulaRepLegal("1234HJ"));
        assertEquals(Mensaje.CAMPOREQUERIDO.getMensaje(), resultado.getMessage());
    }

    /**
     * Prueba que verifica la validación de una cédula de representante legal con una longitud larga.
     */
    @Test
    public void ValidarCedulaRepLegalCedulaLarga() {
        Exception excepcion = assertThrows(Exception.class, () -> validarCedulaRepLegal("1234567890133"));
        assertEquals(Mensaje.LONGITUD_CEDULA.getMensaje(), excepcion.getMessage());
    }

    /**
     * Prueba que verifica la validación de una cédula de representante legal válida.
     */
    @Test
    void ValidarCedulaRepLegalCedulaValida() {
        Boolean resultado = assertDoesNotThrow(() -> validarCedulaRepLegal("1234567890"));
        assertTrue(resultado);
    }
}