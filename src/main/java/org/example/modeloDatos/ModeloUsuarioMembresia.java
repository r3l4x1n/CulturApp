package org.example.modeloDatos;


import jakarta.persistence.*;

@Entity
public class ModeloUsuarioMembresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "costoMensual")
    private Double costoMensual;



    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario")
    private ModeloUsuario modeloUsuario;

*/
    @OneToOne
    @MapsId
    private ModeloUsuario fk;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_invitado", referencedColumnName = "id_cedula")
    private ModeloUsuarioInvitado modeloUsuarioInvitado;


    public ModeloUsuarioMembresia() {
    }

    public ModeloUsuarioMembresia(Double costoMensual, ModeloUsuarioInvitado modeloUsuarioInvitado, ModeloUsuario fk) {

        this.costoMensual = costoMensual;
        this.fk = fk;
        this.modeloUsuarioInvitado = modeloUsuarioInvitado;

    }

    public Double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(Double costoMensual) {
        this.costoMensual = costoMensual;
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

    public void setModeloUsuario(Integer id) {
    }

    public ModeloUsuarioInvitado getModeloUsuarioInvitado() {
        return modeloUsuarioInvitado;
    }

    public void setModeloUsuarioInvitado(ModeloUsuarioInvitado modeloUsuarioInvitado) {
        this.modeloUsuarioInvitado = modeloUsuarioInvitado;
    }
}
