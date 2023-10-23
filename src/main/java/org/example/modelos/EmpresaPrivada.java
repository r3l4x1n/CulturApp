package org.example.modelos;

import static org.example.validacion.UsuarioValidacion.validarNombre;

public class EmpresaPrivada extends Empresa {

    private String representanteLegal;
    private String cedula;


    public EmpresaPrivada() {
    }

    public EmpresaPrivada(Integer id, String nit, String nombre, Integer ubicacion, String descripcion, String representanteLegal, String cedula) {
        super(id, nit, nombre, ubicacion, descripcion);
        this.representanteLegal = representanteLegal;
        this.cedula = cedula;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        try{
            validarNombre(representanteLegal);
            this.representanteLegal = representanteLegal;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public Double calcularCobro(Double costo){
        return costo + (costo * 0.19);
    }



}
