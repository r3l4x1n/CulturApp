package org.example.modeloDatos;


import jakarta.persistence.*;

/**
 * Esta clase representa un modelo de datos para una empresa privada y está anotada para su uso con la API de Persistencia de Java (JPA).
 */
@Entity
public class ModeloEmpresaPrivada{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "representante_legal")
    private String representanteLegal;

    @Column(name = "cedula")
    private String cedula;

    @MapsId
    @OneToOne
    private ModeloEmpresa fk;

    /**
     * Constructor por defecto de la clase ModeloEmpresaPrivada.
     */
    public ModeloEmpresaPrivada() {
    }

    /**
     * Constructor parametrizado de la clase ModeloEmpresaPrivada.
     *
     * @param representanteLegal El nombre del representante legal de la empresa privada.
     * @param cedula             La cédula del representante legal de la empresa privada.
     * @param fk                 La empresa asociada a esta información de empresa privada.
     */
    public ModeloEmpresaPrivada(String representanteLegal, String cedula,ModeloEmpresa fk) {
        this.representanteLegal = representanteLegal;
        this.cedula = cedula;
        this.fk = fk;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ModeloEmpresa getFk() {
        return fk;
    }
    public void setFk(ModeloEmpresa fk) {
        this.fk = fk;
    }
}
