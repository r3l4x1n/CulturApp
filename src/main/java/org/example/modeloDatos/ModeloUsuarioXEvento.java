package org.example.modeloDatos;


import jakarta.persistence.*;

@Entity
public class ModeloUsuarioXEvento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "costo_evento")
    private Double costoPorEvento;

    @OneToOne
    @MapsId
    private ModeloUsuario fk;

    public ModeloUsuarioXEvento() {
    }

    public ModeloUsuarioXEvento(Integer id, String documento, String nombres,
                                String correo, Integer ubicacion, Double costoPorEvento,
                                ModeloUsuario fk) {
        this.costoPorEvento = costoPorEvento;
        this.fk =  fk;
    }

    public Double getCostoPorEvento() {
        return costoPorEvento;
    }

    public void setCostoPorEvento(Double costoPorEvento) {
        this.costoPorEvento = costoPorEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModeloUsuario getFk() {
        return fk;
    }

    public void setFk(ModeloUsuario fk) {
        this.fk = fk;
    }
}
