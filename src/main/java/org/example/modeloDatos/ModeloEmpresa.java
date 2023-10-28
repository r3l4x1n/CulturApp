package org.example.modeloDatos;


import jakarta.persistence.*;

/**
 * Esta clase representa un modelo básico para una entidad llamada "Empresa" en una base de datos.
 * Está anotada para ser utilizada con la API de Persistencia de Java (JPA).
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ModeloEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer id;

    @Column(name = "nit")
    private String nit;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ubicacion")
    private Integer ubicacion;

    @Column(name = "descripcion")
    private String descripcion;


    /**
     * Constructor por defecto para la clase ModeloEmpresa.
     */
    public ModeloEmpresa() {
    }

    /**
     * Constructor parametrizado para la clase ModeloEmpresa.
     *
     * @param nit         El NIT (Número de Identificación Tributaria) de la empresa.
     * @param nombre      El nombre de la empresa.
     * @param ubicacion   La ubicación de la empresa.
     * @param descripcion Una descripción de la empresa.
     */
    public ModeloEmpresa(String nit, String nombre, Integer ubicacion, String descripcion) {
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
