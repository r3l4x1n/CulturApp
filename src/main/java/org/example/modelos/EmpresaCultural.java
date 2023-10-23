package org.example.modelos;

import org.example.modelos.interfaces.IReporte;

public class EmpresaCultural extends Empresa implements IReporte {

    private String entidad;
    private String mision;


    public EmpresaCultural() {
    }

    @Override
    public Double calcularCobro(Double costo) {
        return costo + (costo * 0.19) - (costo* 0.10);
    }

    public EmpresaCultural(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String emailContacto, String numeroContacto, String entidad, String mision) {
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
