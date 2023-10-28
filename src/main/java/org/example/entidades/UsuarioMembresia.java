package org.example.entidades;

import org.example.entidades.interfaces.IAnalitica;
import org.example.entidades.interfaces.IReporte;
import org.example.validacion.UsuarioInvitadoValidacion;

/**
 * Esta clase representa una entidad de usuario con membresía que implementa las interfaces IReporte e IAnalitica.
 * Un usuario con membresía puede generar reportes y realizar análisis de datos.
 */
public class UsuarioMembresia extends Usuario implements IReporte, IAnalitica<UsuarioMembresia> {

    private Double costoMensual;
    private String cedulaInvitado;


    UsuarioInvitadoValidacion usuarioInvitadoValidacion = new UsuarioInvitadoValidacion();

    /**
     * Constructor predeterminado de la clase UsuarioMembresia.
     */
    public UsuarioMembresia() {
    }

    /**
     * Constructor que crea una instancia de UsuarioMembresia con los datos proporcionados.
     *
     * @param id             El identificador único del usuario.
     * @param documento      El documento de identificación del usuario.
     * @param nombres        El nombre del usuario.
     * @param correo         La dirección de correo electrónico del usuario.
     * @param ubicacion      La ubicación del usuario.
     * @param costoMensual   El costo mensual de la membresía del usuario.
     * @param cedulaInvitado La cédula del usuario invitado asociado.
     */
    public UsuarioMembresia(Integer id, String documento, String nombres,
                            String correo, Integer ubicacion, Double costoMensual,
                            String cedulaInvitado) {
        super(id, documento, nombres, correo, ubicacion);
        this.costoMensual = costoMensual;
        this.cedulaInvitado = cedulaInvitado;
    }

    public Double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(Double costoMensual) {
        this.costoMensual = costoMensual;
    }

    public String getCedulaInvitado() {
        return cedulaInvitado;
    }

    public void setCedulaInvitado(String cedulaInvitado) {
            try {
                this.usuarioInvitadoValidacion.validarCedulaInvitado(cedulaInvitado);
                this.cedulaInvitado = cedulaInvitado;
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }

    }




    @Override
    public void generarReporte(String datos) {

    }

    @Override
    public void buscarReporte(Integer id) {

    }

    @Override
    public void editarReporte(Integer id) {

    }

    @Override
    public void limpiarDatos(UsuarioMembresia datos) {

    }

    @Override
    public void calcularDispersion(UsuarioMembresia datos) {

    }



}
