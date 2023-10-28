package org.example.modeloDatos;


import jakarta.persistence.*;

/**
 * Esta clase representa un modelo de datos que relaciona un usuario con un evento y está anotada para su uso con la API de Persistencia de Java (JPA).
 */
@Entity
public class ModeloUsuarioXEvento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "costo_evento")
    private Double costoPorEvento;

    @OneToOne
    @MapsId
    private ModeloUsuario fk;

    /**
     * Constructor por defecto de la clase ModeloUsuarioXEvento.
     */
    public ModeloUsuarioXEvento() {
    }

    /**
     * Constructor de la clase ModeloUsuarioXEvento con parámetros.
     *
     * @param id              Identificador único de la relación usuario-evento.
     * @param documento       Documento de identificación del usuario.
     * @param nombres         Nombres del usuario.
     * @param correo          Correo electrónico del usuario.
     * @param ubicacion       Ubicación del usuario.
     * @param costoPorEvento  Costo asociado al evento para el usuario.
     * @param fk              Usuario asociado al evento.
     */
    public ModeloUsuarioXEvento(Integer id, String documento, String nombres,
                                String correo, Integer ubicacion, Double costoPorEvento,
                                ModeloUsuario fk) {
        this.costoPorEvento = costoPorEvento;
        this.fk =  fk;
    }

    public Double getCostoPorEvento() {
        return costoPorEvento;
    }

    public void setCostoPorEvento(Double costoPorEvento) {
        this.costoPorEvento = costoPorEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModeloUsuario getFk() {
        return fk;
    }

    public void setFk(ModeloUsuario fk) {
        this.fk = fk;
    }
}
