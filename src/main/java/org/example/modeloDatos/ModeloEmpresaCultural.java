package org.example.modeloDatos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ModeloEmpresaCultural extends ModeloEmpresa{

    @Column(name = "entidad",nullable = false)
    private String entidad;

    @Column(name = "mision",nullable = false)
    private String mision;

    public ModeloEmpresaCultural() {
    }

    public ModeloEmpresaCultural(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String entidad, String mision) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.entidad = entidad;
        this.mision = mision;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }
}
