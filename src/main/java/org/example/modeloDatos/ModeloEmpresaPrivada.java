package org.example.modeloDatos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ModeloEmpresaPrivada extends ModeloEmpresa{

    @Column(name = "representante_legal",nullable = false)
    private String representanteLegal;

    @Column(name = "cedula",nullable = false)
    private String cedula;

    public ModeloEmpresaPrivada() {
    }

    public ModeloEmpresaPrivada(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String representanteLegal, String cedula) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.representanteLegal = representanteLegal;
        this.cedula = cedula;
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
}
