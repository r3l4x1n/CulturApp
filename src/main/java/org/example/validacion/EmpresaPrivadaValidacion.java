package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.minimoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;



/**
 * Esta clase proporciona métodos para validar diferentes aspectos de una empresa privada.
 */
public class EmpresaPrivadaValidacion {

    /**
     * Valida el nombre de una empresa cultural.
     *
     * @param nombre El nombre de la empresa cultural a validar.
     * @return true si el nombre cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarNombreRepLegal(String nombre)throws Exception{
        if(!minimoLetras(nombre,9)){
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        }else if(!regExp(nombre,"^[ a-zA-Z]+$")){
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }

    /**
     * Valida la dirección de correo electrónico.
     *
     * @param cedula La dirección de correo electrónico a validar.
     * @return true si el correo cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarCedulaRepLegal(String cedula)throws Exception{
        if (cedula == null || !cedula.matches("^[0-9]+$")) {
            throw new Exception(Mensaje.CAMPOREQUERIDO.getMensaje());
        }
        if (!cedula.matches("\\d{10}")) {
            throw new Exception(Mensaje.LONGITUD_CEDULA.getMensaje());
        }

        return true;
    }

    /**
     * Valida el costo de una empresa privada.
     * Este método verifica si el costo proporcionado cumple con ciertas condiciones.
     * El costo no debe ser mayor que 220,000 y debe ser mayor que 0.
     *
     * @param costo El costo a validar.
     * @return true si el costo cumple con las condiciones, de lo contrario, se lanzará una excepción.
     * @throws Exception Si el costo es mayor que 220,000 o menor o igual a 0, se lanza una excepción.
     */
    public Boolean validarCostoEmpresaPrivada(Double costo) throws Exception{
        if(costo > 220.000){
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        } else if (costo <= 0) {
            throw new Exception(TOPENEGATIVO.getMensaje());
        }
        return true;
    }
}
