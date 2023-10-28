package org.example.modeloDatos;

import jakarta.persistence.*;

/**
 * Esta clase representa un modelo de datos para un usuario y está anotada para su uso con la API de Persistencia de Java (JPA).
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ModeloUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombres;

    @Column(name = "documento", nullable = false)
    private String documento;

    @Column(name = "correo")
    private String correo;

    @Column(name = "ubicacion")
    private Integer ubicacion;

    /**
     * Constructor por defecto de la clase ModeloUsuario.
     */
    public ModeloUsuario() {
    }

    /**
     * Constructor de la clase ModeloUsuario con parámetros.
     *
     * @param documento  Documento de identificación del usuario.
     * @param nombres    Nombres del usuario.
     * @param correo     Correo electrónico del usuario.
     * @param ubicacion  Ubicación del usuario.
     */
    public ModeloUsuario(String documento, String nombres, String correo, Integer ubicacion) {
        this.documento = documento;
        this.nombres = nombres;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }

    public ModeloUsuario(Integer id) {
        this.id = id;
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
