package org.example.modelos;

import java.time.LocalDate;

import static org.example.validacion.OfertaValidacion.*;

public class Oferta {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double costoPersona;
    private Integer idLocal;

    public Oferta() {
    }

    public Oferta(Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Double costoPersona, Integer idLocal) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoPersona = costoPersona;
        this.idLocal = idLocal;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", costoPersona=" + costoPersona +
                ", idLocal=" + idLocal +
                '}';
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
        try{
            validarTitulo(titulo);
            this.titulo = titulo;
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
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

    public void setFechaInicio(String fechaInicio) {
        try{
            this.fechaInicio = validarFecha(fechaInicio);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        try{
            LocalDate nuevaFecha = validarFecha(fechaFin);
            validarFechaFinValida(this.fechaInicio,nuevaFecha);
            this.fechaFin = nuevaFecha;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Double getCostoPersona() {
        return costoPersona;
    }

    public void setCostoPersona(Double costoPersona) {
        try{
            validarCostoPersona(costoPersona);
            this.costoPersona = costoPersona ;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }
}
