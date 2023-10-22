package org.example.modeloDatos;


import jakarta.persistence.*;

@Entity
public class ModeloEmpresaPrivada{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "representante_legal")
    private String representanteLegal;

    @Column(name = "cedula")
    private String cedula;

    @MapsId
    @OneToOne
    private ModeloEmpresa fk;


    public ModeloEmpresaPrivada() {
    }

    public ModeloEmpresaPrivada(String representanteLegal, String cedula,ModeloEmpresa fk) {
        this.representanteLegal = representanteLegal;
        this.cedula = cedula;
        this.fk = fk;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ModeloEmpresa getFk() {
        return fk;
    }
    public void setFk(ModeloEmpresa fk) {
        this.fk = fk;
    }
}
