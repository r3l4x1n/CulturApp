package org.example.entidades;

import static org.example.validacion.EmpresaPrivadaValidacion.validarCedulaRepLegal;
import static org.example.validacion.EmpresaPrivadaValidacion.validarNombreRepLegal;
import static org.example.validacion.UsuarioValidacion.validarDocumento;

/**
 * Esta clase representa una entidad de empresa privada que hereda de la clase base Empresa.
 */
public class EmpresaPrivada extends Empresa {

    private String representanteLegal;
    private String cedula;


    public EmpresaPrivada() {
    }


    /**
     * Crea una nueva instancia de la clase EmpresaPrivada con los datos proporcionados.
     *
     * @param id                El identificador de la empresa privada.
     * @param nit               El NIT (Número de Identificación Tributaria) de la empresa privada.
     * @param nombre            El nombre de la empresa privada.
     * @param ubicacion         La ubicación de la empresa privada.
     * @param descripcion       La descripción de la empresa privada.
     * @param representanteLegal El nombre del representante legal de la empresa privada.
     * @param cedula            La cédula del representante legal de la empresa privada.
     */
    public EmpresaPrivada(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String representanteLegal, String cedula) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.representanteLegal = representanteLegal;
        this.cedula = cedula;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        try {
            validarNombreRepLegal(representanteLegal);
            this.representanteLegal = representanteLegal;
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public String getCedula() { return cedula; }

    public void setCedula(String cedula) {
        try {
            validarCedulaRepLegal(cedula);
            this.cedula = cedula;
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
    /**
     * Calcula el cobro para una empresa privada, aplicando impuestos.
     *
     * @param costo El costo base para el cálculo del cobro.
     * @return El valor del cobro calculado.
     */
    @Override
    public Double calcularCobro(Double costo){
        return costo + (costo * 0.19);
    }



}
