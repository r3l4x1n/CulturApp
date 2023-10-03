package org.example.modeloDatos;


import jakarta.persistence.*;

@Entity
public class ModeloEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer id;

    @Column(name = "nit",nullable = false)
    private String nit;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "ubicacion",nullable = false)
    private Integer ubicacion;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    public ModeloEmpresa() {
    }

    public ModeloEmpresa(Integer id, String nit, String nombre, Integer ubicacion, String descripcion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
