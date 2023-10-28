package org.example.entidades;

import static org.example.validacion.EmpresaValidacion.*;

/**
 * Esta es una clase abstracta que representa una entidad genérica de empresa.
 */
public abstract class Empresa {
    private Integer id;
    private String nit;
    private String nombre;
    private Integer ubicacion;
    private String descripcion;

    public Empresa() {
    }

    public Empresa(Integer id, String nit, String nombre, Integer ubicacion, String descripcion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    /**
     * Devuelve una representación en cadena de la empresa.
     *
     * @return Una cadena que describe la empresa.
     */
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion=" + ubicacion +
                ", descripcion='" + descripcion + '\'' +
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        try {
            validarDescripcion(descripcion);
            this.descripcion = descripcion;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método abstracto para calcular el cobro de la empresa.
     *
     * @param costo El costo sobre el cual se realiza el cálculo del cobro.
     * @return El valor del cobro calculado.
     */
    public abstract Double calcularCobro(Double costo);

}
