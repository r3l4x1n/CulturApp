package org.example.modeloDatos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ModeloUsuarioPagoXEvento extends ModeloUsuario {

    @Column(name = "costo_evento",nullable = false)
    private Double costoPorEvento;

    public ModeloUsuarioPagoXEvento() {
    }

    public ModeloUsuarioPagoXEvento(Integer id, String documento, String nombres, String correo, Integer ubicacion, Double costoPorEvento) {
        super(id, documento, nombres, correo, ubicacion);
        this.costoPorEvento = costoPorEvento;
    }

    public Double getCostoPorEvento() {
        return costoPorEvento;
    }

    public void setCostoPorEvento(Double costoPorEvento) {
        this.costoPorEvento = costoPorEvento;
    }
}
