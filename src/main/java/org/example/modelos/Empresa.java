package org.example.modelos;

import static org.example.validacion.EmpresaValidacion.*;

public abstract class Empresa {
    private Integer id;
    private String nit;
    private String nombre;
    private Integer ubicacion;
    private String mision;
    private String emailContacto;
    private String numeroContacto;

    public Empresa() {
    }

    public Empresa(Integer id, String nit, String nombre, Integer ubicacion, String descripcion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.mision = mision;
        this.emailContacto = emailContacto;
        this.numeroContacto = numeroContacto;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion=" + ubicacion +
                ", mision='" + mision + '\'' +
                ", emailContacto='" + emailContacto + '\'' +
                ", numeroContacto='" + numeroContacto + '\'' +
                '}';
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
        try{
            validarNit(nit);
            this.nit = nit;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
       try{
           validarNombre(nombre);
           this.nombre = nombre;
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String descripcion) {
        this.mision = descripcion;
    }

    public abstract Double calcularCobro(Double costo);

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
}
