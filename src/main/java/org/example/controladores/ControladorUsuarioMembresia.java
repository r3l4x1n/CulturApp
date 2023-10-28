package org.example.controladores;

import com.google.gson.JsonObject;
import org.example.entidades.UsuarioMembresia;
import org.example.modeloDatos.ModeloUsuarioMembresia;
import org.example.servicios.ServicioUsuarioMembresia;

import java.util.List;

public class ControladorUsuarioMembresia {

    UsuarioMembresia usuarioMembresia = new UsuarioMembresia();

    ServicioUsuarioMembresia servicioUsuarioMembresia = new ServicioUsuarioMembresia();

    public void agregarUsuario(String nombre, String documento,
                                 String correo, String ubicacion, Double costoMensual,
                                 String cedulaInvitado){

        if(!"0".equals(cedulaInvitado)){
            this.usuarioMembresia.setCedulaInvitado(cedulaInvitado);
            this.usuarioMembresia.setNombres(nombre);
            this.usuarioMembresia.setDocumento(documento);
            this.usuarioMembresia.setCorreo(correo);
            this.usuarioMembresia.setUbicacion(Integer.valueOf(ubicacion));
            this.usuarioMembresia.setCostoMensual(costoMensual);


            this.servicioUsuarioMembresia.registrarUsuario(usuarioMembresia);
        }else {
            this.usuarioMembresia.setNombres(nombre);
            this.usuarioMembresia.setDocumento(documento);
            this.usuarioMembresia.setCorreo(correo);
            this.usuarioMembresia.setUbicacion(Integer.valueOf(ubicacion));
            this.usuarioMembresia.setCostoMensual(costoMensual);


            this.servicioUsuarioMembresia.registrarUsuario(usuarioMembresia);
        }




    }

    public void consultarUsuario() {
        List<ModeloUsuarioMembresia> usuarios = servicioUsuarioMembresia.buscarUsuario();
        JsonObject jsonObject = new JsonObject();
        for (ModeloUsuarioMembresia usuario: usuarios) {
            jsonObject.addProperty("nombre: ",usuario.getFk().getNombres());
            jsonObject.addProperty(" documento: ",usuario.getFk().getDocumento());
            jsonObject.addProperty(" correo: ",usuario.getFk().getCorreo());
            jsonObject.addProperty("ubicación : ",usuario.getFk().getDocumento());
            jsonObject.addProperty("costo mensual",usuario.getCostoMensual());
            jsonObject.addProperty("Cedula invitado: ",usuario.getModeloUsuarioInvitado().getCedula());
            jsonObject.addProperty("fecha invitación: ", usuario.getModeloUsuarioInvitado().getFechaInvitacion().toString());
            jsonObject.addProperty("fecha finalización invitación: ", usuario.getModeloUsuarioInvitado().getFechaFinalizacion().toString());

            System.out.println(jsonObject);
        }

    }


}
