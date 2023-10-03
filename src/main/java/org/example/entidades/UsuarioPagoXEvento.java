package org.example.entidades;

public class UsuarioPagoXEvento extends Usuario{
    private Double costoPorEvento;

    public UsuarioPagoXEvento() {
    }

    public UsuarioPagoXEvento(Integer id, String documento, String nombres, String correo, Integer ubicacion, Double costoPorEvento) {
        super(id, documento, nombres, correo, ubicacion);
        this.costoPorEvento = costoPorEvento;
    }

    public Double getCostoPorEvento() {
        return costoPorEvento;
    }

    public void setCostoPorEvento(Double costoPorEvento) {
        this.costoPorEvento = costoPorEvento;
    }

    public void calcularDescuento(){}
}
