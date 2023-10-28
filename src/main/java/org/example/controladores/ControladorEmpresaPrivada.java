package org.example.controladores;

import com.google.gson.JsonObject;
import org.example.entidades.EmpresaPrivada;
import org.example.modeloDatos.ModeloEmpresaPrivada;
import org.example.servicios.ServicioEmpresaPrivada;

import java.util.List;
/**
 * Esta clase representa un controlador para gestionar las operaciones relacionadas con empresas privadas.
 */
public class ControladorEmpresaPrivada {

    EmpresaPrivada empresaPrivada = new EmpresaPrivada();
    ServicioEmpresaPrivada servicioEmpresaPrivada = new ServicioEmpresaPrivada();

    /**
     * Agrega una empresa privada con la información proporcionada.
     *
     * @param nit               El NIT de la empresa.
     * @param nombre            El nombre de la empresa.
     * @param ubicacion         La ubicación de la empresa.
     * @param descripcion       La descripción de la empresa.
     * @param representanteLegal El representante legal de la empresa.
     * @param cedula            La cédula del representante legal.
     */
    public void agregarEmpresa(String nit,String nombre, String ubicacion,
                               String descripcion, String representanteLegal,
                               String cedula) {

        this.empresaPrivada.setNit(nit);
        this.empresaPrivada.setNombre(nombre);
        this.empresaPrivada.setUbicacion(Integer.valueOf(ubicacion));
        this.empresaPrivada.setDescripcion(descripcion);
        this.empresaPrivada.setRepresentanteLegal(representanteLegal);
        this.empresaPrivada.setCedula(cedula);
        this.servicioEmpresaPrivada.registrarEmpresa(empresaPrivada);


    }

    /**
     * Consulta y muestra información sobre las empresas privadas registradas.
     */

    public void consultarEmpresa(){
        List<ModeloEmpresaPrivada> empresas = servicioEmpresaPrivada.buscarEmpresa();
        JsonObject jsonObject = new JsonObject();

        for (ModeloEmpresaPrivada empresa:empresas) {
            jsonObject.addProperty("Nombre: ",empresa.getFk().getNombre());
            jsonObject.addProperty("Descripción: ",empresa.getFk().getDescripcion());
            jsonObject.addProperty("Nit: ", empresa.getFk().getNit());
            jsonObject.addProperty("Ubicación ", empresa.getFk().getUbicacion());
            jsonObject.addProperty("Representante legal", empresa.getRepresentanteLegal());
            jsonObject.addProperty("Cedula representante: ", empresa.getCedula());

            System.out.println(jsonObject);
        }

    }
}
