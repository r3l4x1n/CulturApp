package org.example.entidades;

import java.time.LocalDate;

import static org.example.validacion.OfertaValidacion.*;

/**
 * Esta clase representa una entidad de oferta que puede ser asociada a empresas culturales.
 */
public class Oferta {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double costoPersona;
    private Integer idEmpresa;

    public Oferta() {
    }

    /**
     * Constructor de la clase Oferta para crear una nueva instancia con los datos proporcionados.
     *
     * @param id                    El identificador único de la oferta.
     * @param titulo                El título de la oferta.
     * @param descripcion           La descripción de la oferta.
     * @param fechaInicio           La fecha de inicio de la oferta.
     * @param fechaFin              La fecha de finalización de la oferta.
     * @param costoPersona          El costo por persona de la oferta.
     * @param idEmpresa             El identificador de la empresa asociada a la oferta.
     * @param asociadaEmpresaCultural Indica si la oferta está asociada a una empresa cultural.
     */
    public Oferta(Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Double costoPersona, Integer idEmpresa,Boolean asociadaEmpresaCultural) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoPersona = costoPersona;
        this.idEmpresa = idEmpresa;
    }

    /**
     * Obtiene una representación en forma de cadena de la oferta.
     *
     * @return Una cadena que muestra los atributos de la oferta.
     */
    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", costoPersona=" + costoPersona +
                ", idEmpresa=" + idEmpresa +
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

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}
