package org.example.controladores;


import com.google.gson.JsonObject;
import org.example.entidades.EmpresaCultural;
import org.example.entidades.Oferta;
import org.example.entidades.UsuarioPagoXEvento;
import org.example.modeloDatos.ModeloUsuarioXEvento;
import org.example.servicios.ServicioUsuarioXEvento;

import java.util.List;

public class ControladorUsuarioXEvento {

    UsuarioPagoXEvento usuarioPagoXEvento = new UsuarioPagoXEvento();

    ServicioUsuarioXEvento servicioUsuarioXEvento = new ServicioUsuarioXEvento();

    public void agregarUsuario(String nombre, String documento,
                               String correo, String ubicacion, Double costoPorEvento){


        this.usuarioPagoXEvento.setNombres(nombre);
        this.usuarioPagoXEvento.setDocumento(documento);
        this.usuarioPagoXEvento.setCorreo(correo);
        this.usuarioPagoXEvento.setUbicacion(Integer.valueOf(ubicacion));


        this.usuarioPagoXEvento.setCostoPorEvento(costoPorEvento);


        this.servicioUsuarioXEvento.registrarUsuario(usuarioPagoXEvento);

    }



    public void consultarUsuario(){
        List<ModeloUsuarioXEvento> usuarios = servicioUsuarioXEvento.buscarUsuario();
        JsonObject jsonObject = new JsonObject();
        for (ModeloUsuarioXEvento usuario :usuarios) {
            jsonObject.addProperty("nombre: ",usuario.getFk().getNombres());
            jsonObject.addProperty(" documento: ",usuario.getFk().getDocumento());
            jsonObject.addProperty(" correo: ",usuario.getFk().getCorreo());
            jsonObject.addProperty("ubicación : ",usuario.getFk().getDocumento());
            jsonObject.addProperty("Costo por evento: ", usuario.getCostoPorEvento());

            System.out.println(jsonObject);

        }


    }



}
