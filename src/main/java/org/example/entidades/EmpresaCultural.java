package org.example.entidades;

import org.example.entidades.interfaces.IReporte;
import org.example.validacion.EmpresaCulturalValidacion;

public class EmpresaCultural extends Empresa implements IReporte {
    private String entidad;
    private String mision;
    private String emailContacto;
    private String numeroContacto;

    EmpresaCulturalValidacion empresaCulturalValidacion = new EmpresaCulturalValidacion();



    public EmpresaCultural() {
    }

    @Override
    public Double calcularCobro(Double costo) {
        return costo + (costo * 0.19) - (costo* 0.10);
    }

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
