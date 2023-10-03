package org.example.entidades;


import static org.example.validacion.UsuarioValidacion.*;

public class Usuario {
    private Integer id;
    private String documento;
    private String nombres;
    private String correo;
    private Integer ubicacion;

    public Usuario() {
    }

    public Usuario(Integer id, String documento, String nombres , String correo, Integer ubicacion) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres ;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", nombres ='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                ", ubicacion=" + ubicacion +
                '}';
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

    public String getNombres () {
        return nombres ;
    }

    public void setNombres (String nombres ) {
        try{
            validarNombre(nombres);
            this.nombres = nombres;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        try{
            validarCorreo(correo);
            this.correo = correo;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        try{
            this.ubicacion = validarUbicacion(ubicacion);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void registrar(){

    }
}
