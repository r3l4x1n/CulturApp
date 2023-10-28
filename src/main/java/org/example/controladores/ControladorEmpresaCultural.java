package org.example.controladores;

import com.google.gson.JsonObject;
import org.example.entidades.EmpresaCultural;
import org.example.modeloDatos.ModeloEmpresaCultural;
import org.example.servicios.ServicioEmpresaCultural;

import java.util.List;
/**
 * Controlador para gestionar empresas culturales.
 */
public class ControladorEmpresaCultural {

    EmpresaCultural empresaCultural = new EmpresaCultural();
    ServicioEmpresaCultural servicioEmpresaCultural = new ServicioEmpresaCultural();

    /**
     * Agrega una empresa cultural.
     *
     * @param nit NIT de la empresa.
     * @param nombre Nombre de la empresa.
     * @param ubicacion Ubicación de la empresa.
     * @param descripcion Descripción de la empresa.
     * @param entidad Entidad a la que pertenece la empresa.
     * @param emailContacto Correo electrónico de contacto.
     * @param numeroContacto Número de contacto.
     * @param mision Misión de la empresa.
     */
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
    /**
     * Consulta y muestra información de empresas culturales.
     */
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
