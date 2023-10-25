package org.example.entidades;

import org.example.validacion.UsuarioInvitadoValidacion;

import java.time.LocalDate;

public class UsuarioInvitado {

    private Integer id;
    private String cedula;
    private LocalDate fechaInvitacion;
    private LocalDate fechaFinalizacion;

    UsuarioInvitadoValidacion usuarioInvitadoValidacion = new UsuarioInvitadoValidacion();

    public UsuarioInvitado() {
    }

    public UsuarioInvitado(Integer id,String cedula, LocalDate fechaInvitacion,
                           LocalDate fechaFinalizacion) {
        this.id = id;
        this.cedula = cedula;
        this.fechaInvitacion = fechaInvitacion;
        this.fechaFinalizacion = fechaFinalizacion;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {

        try{
            this.usuarioInvitadoValidacion.validarCedulaInvitado(cedula);
            this.cedula = cedula;
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
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


    @Override
    public String toString() {
        return "UsuarioInvitado{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", fechaInvitacion=" + fechaInvitacion +
                ", fechaFinalizacion=" + fechaFinalizacion +
                '}';
    }
}
