package org.example.modelos;

import org.example.modelos.interfaces.IAnalitica;
import org.example.modelos.interfaces.IReporte;

public class UsuarioMembresia extends Usuario implements IReporte, IAnalitica<UsuarioMembresia> {

    private Double costoMensual;

    public UsuarioMembresia() {
    }

    public UsuarioMembresia(Integer id, String documento, String nombres, String correo, Integer ubicacion, Double costoMensual) {
        super(id, documento, nombres, correo, ubicacion);
        this.costoMensual = costoMensual;
    }

    public Double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(Double costoMensual) {
        this.costoMensual = costoMensual;
    }

    public void agregarInvitado(String id){}

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
    public void limpiarDatos(UsuarioMembresia datos) {

    }

    @Override
    public void calcularDispersion(UsuarioMembresia datos) {

    }
}
