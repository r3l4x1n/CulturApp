package org.example.validacion;

import org.example.utilidades.Mensaje;

import static org.example.utilidades.Caracteres.maximoLetras;
import static org.example.utilidades.Caracteres.minimoLetras;
import static org.example.utilidades.ExpresionesRegulares.regExp;
import static org.example.utilidades.Mensaje.COSTOSUPERIOREMPRESAS;
import static org.example.utilidades.Mensaje.TOPENEGATIVO;

/**
 * Esta clase proporciona métodos para validar diferentes aspectos de una empresa cultural.
 */
public class EmpresaCulturalValidacion {

    /**
     * Valida el nombre de una empresa cultural.
     *
     * @param nombre El nombre de la empresa cultural a validar.
     * @return true si el nombre cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static boolean validarNombreEmpresaCultural(String nombre)throws Exception{
        if (!minimoLetras(nombre, 9)){
            throw new Exception(Mensaje.CANTIDADLETRAS.getMensaje());
        } else if (!regExp(nombre,"^[ a-zA-Z]+$")) {
            throw new Exception(Mensaje.CARACTERESNOMBRE.getMensaje());
        }
        return true;
    }

    /**
     * Valida la dirección de correo electrónico.
     *
     * @param correo La dirección de correo electrónico a validar.
     * @return true si el correo cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public static Boolean validarEMail(String correo)throws Exception{
        if(!regExp(correo,"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new Exception(Mensaje.CARACTERESCORREO.getMensaje());
        }
        return true;
    }

    /**
     * Valida la entidad de la empresa cultural.
     *
     * @param entidad La entidad de la empresa cultural a validar.
     * @return true si la entidad cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public Boolean validarEntidad(String entidad) throws Exception{
        if(!maximoLetras(entidad,30)){
            throw new Exception(Mensaje.CANTIDADEXCESIVA.getMensaje());
        }else if (regExp(entidad,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }
    /**
     * Valida la misión de la empresa cultural.
     *
     * @param mision La misión de la empresa cultural a validar.
     * @return true si la misión cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public Boolean validarMision(String mision) throws Exception{
        if(!maximoLetras(mision,150)){
            throw new Exception(Mensaje.CANTIDADEXCESIVA.getMensaje());
        }else if (regExp(mision,"^[ a-zA-Z0-9._%+-]$")) {
            throw new Exception();
        }
        return true;
    }

    /**
     * Valida el costo de la empresa cultural.
     *
     * @param costo El costo de la empresa cultural a validar.
     * @return true si el costo cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public Boolean validarCostoEmpresaCultural1(Double costo) throws Exception {

        double costoBase = 1200000;
        double iva = 0.19;
        double descuento = 0.10;

        double cobroTotal = (costoBase + (costoBase * iva)) * (1 - descuento);

        if (costo > cobroTotal) {
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        }
        else if (costo <= 0) {
            throw new Exception(TOPENEGATIVO.getMensaje());
        }

        return true;
    }

    /**
     * Valida el costo de la empresa cultural.
     *
     * @param costo El costo de la empresa cultural a validar.
     * @return true si el costo cumple con los requisitos de validación, de lo contrario lanza una excepción con el mensaje de error correspondiente.
     * @throws Exception Si la validación no es exitosa.
     */
    public Boolean validarCostoEmpresaCultural(Double costo)throws Exception{

        if(costo > 120.000){
            throw new Exception(COSTOSUPERIOREMPRESAS.getMensaje());
        }else if(costo <= 0){
            throw new Exception(TOPENEGATIVO.getMensaje());
        }
        return true;
    }
}
