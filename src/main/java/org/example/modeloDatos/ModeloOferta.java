package org.example.modeloDatos;


import jakarta.persistence.*;

import java.time.LocalDate;


/**
 * Esta clase representa un modelo de datos para una oferta y está anotada para su uso con la API de Persistencia de Java (JPA).
 */
@Entity
public class ModeloOferta {



    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private Integer id;

    @Column(name = "titulo",nullable = false)
    private String titulo;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio",nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin",nullable = false)
    private LocalDate fechaFin;

    @Column(name = "costo_persona",nullable = false)
    private Double costoPersona;

    @Column(name = "id_empresa",nullable = false)
    private Integer idEmpresa;

    public ModeloOferta() {
    }

    public ModeloOferta(Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Double costoPersona, Integer idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoPersona = costoPersona;
        this.idEmpresa = idEmpresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getCostoPersona() {
        return costoPersona;
    }

    public void setCostoPersona(Double costoPersona) {
        this.costoPersona = costoPersona;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
