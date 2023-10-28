package org.example.entidades;

/**
 * Esta clase representa una entidad de usuario que paga por eventos. Hereda de la clase Usuario.
 * Los usuarios que pagan por evento tienen un costo asociado por cada evento en el que participan.
 */
public class UsuarioPagoXEvento extends Usuario{
    private Double costoPorEvento;

    /**
     * Constructor predeterminado de la clase UsuarioPagoXEvento.
     */
    public UsuarioPagoXEvento() {
    }

    /**
     * Constructor que crea una instancia de UsuarioPagoXEvento con los datos proporcionados.
     *
     * @param id             El identificador único del usuario.
     * @param documento      El documento de identificación del usuario.
     * @param nombres        El nombre del usuario.
     * @param correo         La dirección de correo electrónico del usuario.
     * @param ubicacion      La ubicación del usuario.
     * @param costoPorEvento El costo asociado por cada evento en el que participa el usuario.
     */
    public UsuarioPagoXEvento(Integer id, String documento, String nombres, String correo, Integer ubicacion, Double costoPorEvento) {
        super(id, documento, nombres, correo, ubicacion);
        this.costoPorEvento = costoPorEvento;
    }

    public Double getCostoPorEvento() {
        return costoPorEvento;
    }

    public void setCostoPorEvento(Double costoPorEvento) {
        this.costoPorEvento = costoPorEvento;
    }

    public void calcularDescuento(){

    }
}
