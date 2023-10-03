package org.example.modeloDatos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ModeloUsuarioMembresia extends ModeloUsuario{

    @Column(name = "costo_mensual",nullable = false)
    private Double costoMensual;

    public ModeloUsuarioMembresia() {
    }

    public ModeloUsuarioMembresia(Integer id, String documento, String nombres, String correo, Integer ubicacion, Double costoMensual) {
        super(id, documento, nombres, correo, ubicacion);
        this.costoMensual = costoMensual;
    }

    public Double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(Double costoMensual) {
        this.costoMensual = costoMensual;
    }
}
