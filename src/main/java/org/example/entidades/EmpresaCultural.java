package org.example.entidades;

import org.example.entidades.interfaces.IReporte;
import org.example.validacion.EmpresaCulturalValidacion;

/**
 * Esta clase representa una entidad de empresa cultural que implementa la interfaz IReporte.
 */
public class EmpresaCultural extends Empresa implements IReporte {
    private String entidad;
    private String mision;
    private String emailContacto;
    private String numeroContacto;

    EmpresaCulturalValidacion empresaCulturalValidacion = new EmpresaCulturalValidacion();



    public EmpresaCultural() {
    }

    /**
     * Calcula el cobro para una empresa cultural, aplicando impuestos y descuentos.
     *
     * @param costo El costo base para el cálculo del cobro.
     * @return El valor del cobro calculado.
     */
    @Override
    public Double calcularCobro(Double costo) {
        return costo + (costo * 0.19) - (costo* 0.10);
    }

    /**
     * Crea una nueva instancia de la clase EmpresaCultural con los datos proporcionados.
     *
     * @param id           El identificador de la empresa cultural.
     * @param nit          El NIT (Número de Identificación Tributaria) de la empresa cultural.
     * @param nombre       El nombre de la empresa cultural.
     * @param ubicacion    La ubicación de la empresa cultural.
     * @param descripcion  La descripción de la empresa cultural.
     * @param entidad      La entidad a la que pertenece la empresa cultural.
     * @param mision       La misión de la empresa cultural.
     * @param emailContacto El correo electrónico de contacto de la empresa cultural.
     * @param numeroContacto El número de contacto de la empresa cultural.
     */
    public EmpresaCultural(Integer id, String nit, String nombre, Integer ubicacion, String descripcion,
                           String entidad, String mision, String emailContacto,String numeroContacto) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.entidad = entidad;
        this.mision = mision;
        this.emailContacto = emailContacto;
        this.numeroContacto = numeroContacto;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
      try {
          empresaCulturalValidacion.validarEntidad(entidad);
          this.entidad = entidad;
      }catch (Exception e){
          System.out.println(e.getMessage());
      }
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        try {
            empresaCulturalValidacion.validarMision(mision);
            this.mision = mision;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    @Override
    public void generarReporte(String datos) {

    }

    @Override
    public void buscarReporte(Integer id) {

    }

    @Override
    public void editarReporte(Integer id) {

    }

    @Override
    public void eliminarReporte(Integer identidicacion) {
        IReporte.super.eliminarReporte(identidicacion);
    }
}

