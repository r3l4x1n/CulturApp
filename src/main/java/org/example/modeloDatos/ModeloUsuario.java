package org.example.modeloDatos;


import jakarta.persistence.*;

@Entity
public class ModeloUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "documento",nullable = false)
    private String documento;

    @Column(name = "nombres",nullable = false)
    private String nombres;

    @Column(name = "correo",nullable = false)
    private String correo;

    @Column(name = "ubicacion",nullable = false)
    private Integer ubicacion;

    public ModeloUsuario() {
    }

    public ModeloUsuario(Integer id, String documento, String nombres, String correo, Integer ubicacion) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }
}
