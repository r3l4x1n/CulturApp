package org.example.entidades;

import java.time.LocalDate;

import static org.example.validacion.ReservaValidacion.validarCantidadPersonas;
import static org.example.validacion.ReservaValidacion.validarFecha;

/**
 * Esta clase representa una entidad de reserva para ofertas culturales. Las reservas se asocian a usuarios y ofertas específicas.

 * Una reserva contiene información sobre la cantidad de personas, el costo total y la fecha de la reserva.
 */
public class Reserva {
    private Integer id;
    private Integer idUsuario;
    private Integer idOferta;
    private Double costoTotal;
    private LocalDate fechaReserva;
    private Integer cantidadPersonas;

    /**
     * Constructor predeterminado de la clase Reserva.
     */
    public Reserva() {
    }

    /**
     * Constructor que crea una instancia de Reserva con los datos proporcionados.
     *
     * @param id             El identificador único de la reserva.
     * @param idUsuario      El identificador del usuario que realiza la reserva.
     * @param idOferta       El identificador de la oferta asociada a la reserva.
     * @param costoTotal     El costo total de la reserva.
     * @param fechaReserva   La fecha en la que se realizó la reserva.
     * @param cantidadPersonas La cantidad de personas incluidas en la reserva.
     */
    public Reserva(Integer id, Integer idUsuario, Integer idOferta, Double costoTotal, LocalDate fechaReserva,Integer cantidadPersonas) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idOferta = idOferta;
        this.costoTotal = costoTotal;
        this.fechaReserva = fechaReserva;
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idOferta=" + idOferta +
                ", costoTotal=" + costoTotal +
                ", fechaReserva=" + fechaReserva +
                ", cantidadPersonas=" + cantidadPersonas +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        try{
            LocalDate nuevaFecha = validarFecha(fechaReserva);
            this.fechaReserva = nuevaFecha;
        } catch (Exception e){
            System.out.println(e.getMessage());}
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        try{
            validarCantidadPersonas(cantidadPersonas);
            this.cantidadPersonas = cantidadPersonas;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
