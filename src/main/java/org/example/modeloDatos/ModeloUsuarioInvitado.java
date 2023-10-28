package org.example.modeloDatos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * Esta clase representa un modelo de datos para un usuario invitado y está anotada para su uso con la API de Persistencia de Java (JPA).
 */
@Entity
public class ModeloUsuarioInvitado {

    @Id
    @Column(name = "id_cedula")
    private String cedula;

    @Column(name = "fecha_invitacion")
    private LocalDate fechaInvitacion;

    @Column(name = "fecha_finalizacion")
    private LocalDate fechaFinalizacion;

    /**
     * Constructor por defecto de la clase ModeloUsuarioInvitado.
     */
    public ModeloUsuarioInvitado() {
    }

    /**
     * Constructor de la clase ModeloUsuarioInvitado con un número de cédula.
     *
     * @param cedula Número de cédula del usuario invitado. Si es "0", se considera como una invitación nula.
     */
    public ModeloUsuarioInvitado(String cedula) {

        //"0" != cedula
        if(!"0".equals(cedula)){
            this.cedula = cedula;
            this.fechaInvitacion = LocalDate.now();
            this.fechaFinalizacion = fechaInvitacion.plusDays(5);
        }else{
            this.cedula = "null";
            this.fechaInvitacion = null;
            this.fechaFinalizacion = null;
        }

    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaInvitacion() {
        return fechaInvitacion;
    }

    public void setFechaInvitacion(LocalDate fechaInvitacion) {
        this.fechaInvitacion = fechaInvitacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
