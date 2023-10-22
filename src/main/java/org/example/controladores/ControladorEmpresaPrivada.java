package org.example.controladores;

import com.google.gson.JsonObject;
import org.example.entidades.EmpresaPrivada;
import org.example.modeloDatos.ModeloEmpresaPrivada;
import org.example.servicios.ServicioEmpresaPrivada;

import java.util.List;

public class ControladorEmpresaPrivada {

    EmpresaPrivada empresaPrivada = new EmpresaPrivada();
    ServicioEmpresaPrivada servicioEmpresaPrivada = new ServicioEmpresaPrivada();


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
