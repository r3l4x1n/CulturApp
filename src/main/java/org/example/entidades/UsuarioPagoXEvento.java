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


    //ESTE METODO LO AGREGO PARA CALCULAR DESCUENTO DE USUARIOXEVENTO
    public Double calcularDescuento(Oferta oferta){
        if (oferta != null && oferta.isAsociadaEmpresaCultural()) {
            return oferta.getCostoPersona() * 0.7;
        } else {
            return oferta.getCostoPersona();
        }
    }
}
