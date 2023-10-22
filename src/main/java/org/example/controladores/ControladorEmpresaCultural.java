package org.example.controladores;

import com.google.gson.JsonObject;
import org.example.entidades.EmpresaCultural;
import org.example.modeloDatos.ModeloEmpresaCultural;
import org.example.servicios.ServicioEmpresaCultural;

import java.util.List;

public class ControladorEmpresaCultural {

    EmpresaCultural empresaCultural = new EmpresaCultural();
    ServicioEmpresaCultural servicioEmpresaCultural = new ServicioEmpresaCultural();


    public void agregarEmpresa(String nit,String nombre, String ubicacion,
                               String descripcion, String entidad, String emailContacto,
                               String numeroContacto, String mision){

        this.empresaCultural.setNit(nit);
        this.empresaCultural.setNombre(nombre);
        this.empresaCultural.setUbicacion(Integer.valueOf(ubicacion));
        this.empresaCultural.setDescripcion(descripcion);
        this.empresaCultural.setEntidad(entidad);
        this.empresaCultural.setEmailContacto(emailContacto);
        this.empresaCultural.setNumeroContacto(numeroContacto);
        this.empresaCultural.setMision(mision);
        this.servicioEmpresaCultural.registrarEmpresa(empresaCultural);


    }

    public void consultarEmpresa(){
        List<ModeloEmpresaCultural> empresas = servicioEmpresaCultural.buscarEmpresa();
        JsonObject jsonObject = new JsonObject();

        for (ModeloEmpresaCultural empresa:empresas) {
            jsonObject.addProperty("Nombre: ",empresa.getFk().getNombre());
            jsonObject.addProperty("Descripción: ",empresa.getFk().getDescripcion());
            jsonObject.addProperty("Nit: ", empresa.getFk().getNit());
            jsonObject.addProperty("Ubicación ", empresa.getFk().getUbicacion());
            jsonObject.addProperty("Misión: ",empresa.getMision());
            jsonObject.addProperty("Entidad: ",empresa.getEntidad());
            jsonObject.addProperty("Email contacto: ",empresa.getEmailContacto());
            jsonObject.addProperty("Numero contacto: ",empresa.getNumeroContacto());

            System.out.println(jsonObject);
        }

    }



}
