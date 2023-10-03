package org.example.entidades;

import org.example.entidades.interfaces.IReporte;

public class EmpresaCultural extends Empresa implements IReporte {





    private String entidad;
    private String mision;
    /*
    private String emailContacto;
    private String numeroContacto;*/



    public EmpresaCultural() {
    }

    @Override
    public Double calcularCobro(Double costo) {
        return costo + (costo * 0.19) - (costo* 0.10);
    }

    public EmpresaCultural(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String entidad, String mision) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.entidad = entidad;
        this.mision = mision;
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
