package org.example.modeloDatos;


import jakarta.persistence.*;

@Entity
public class ModeloEmpresaCultural{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entidad")
    private String entidad;

    @Column(name = "mision")
    private String mision;

    @Column(name = "email_contacto")
    private String emailContacto;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @OneToOne
    @MapsId
    private ModeloEmpresa fk;



    public ModeloEmpresaCultural() {
    }


    public ModeloEmpresaCultural(String entidad, String mision,
                                 String emailContacto, String numeroContacto, ModeloEmpresa fk) {
        this.entidad = entidad;
        this.mision = mision;
        this.emailContacto = emailContacto;
        this.numeroContacto = numeroContacto;
        this.fk = fk;
    }



    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {this.emailContacto = emailContacto;}
    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public ModeloEmpresa getFk() {
        return fk;
    }

    public void setFk(ModeloEmpresa fk) {
        this.fk = fk;
    }
}
