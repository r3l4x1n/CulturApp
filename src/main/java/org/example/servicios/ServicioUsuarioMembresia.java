package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.UsuarioMembresia;
import org.example.modeloDatos.ModeloUsuario;
import org.example.modeloDatos.ModeloUsuarioInvitado;
import org.example.modeloDatos.ModeloUsuarioMembresia;

import java.util.List;

/**
 * Este servicio proporciona métodos para registrar y buscar usuarios con membresía en la base de datos.
 */
public class ServicioUsuarioMembresia {

    /**
     * Registra un usuario con membresía en la base de datos.
     *
     * @param usuarioMembresia El usuario con membresía que se va a registrar.
     */
    public void registrarUsuario(UsuarioMembresia usuarioMembresia){
        String configuracionPersistencia = "conexionBD";

        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory(configuracionPersistencia);
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            ModeloUsuarioMembresia modeloUsuarioMembresia =
                    getModeloUsuarioMembresia(usuarioMembresia);


            //Inicio de la transacción
            entityManager.getTransaction().begin();

            //Activar persistencia
            //entityManager.persist(modeloUsuario);
            entityManager.persist(modeloUsuarioMembresia);

            //Registro de la operacion
            entityManager.getTransaction().commit();

            System.out.println("Exito en la transacción. Usuario registrado exitosamente");

        } catch (Exception error) {
            System.out.println("Fallamos " + error.getMessage());
        }
    }

    /**
     * Convierte una instancia de la clase `UsuarioMembresia` en una instancia de `ModeloUsuarioMembresia`.
     *
     * @param usuarioMembresia El usuario con membresía que se va a convertir.
     * @return La instancia de `ModeloUsuarioMembresia` creada a partir del usuario con membresía.
     */
    private static ModeloUsuarioMembresia getModeloUsuarioMembresia(UsuarioMembresia usuarioMembresia) {
        ModeloUsuarioMembresia modeloUsuarioMembresia = new ModeloUsuarioMembresia();
        modeloUsuarioMembresia.setFk(new ModeloUsuario(
                usuarioMembresia.getDocumento(),usuarioMembresia.getNombres(),
                usuarioMembresia.getCorreo(), usuarioMembresia.getUbicacion()
        ));

        modeloUsuarioMembresia.setCostoMensual(usuarioMembresia.getCostoMensual());
        modeloUsuarioMembresia.setModeloUsuarioInvitado(
                new ModeloUsuarioInvitado(usuarioMembresia.getCedulaInvitado()));



        return modeloUsuarioMembresia;
    }

    /**
     * Busca y devuelve una lista de usuarios con membresía en la base de datos.
     *
     * @return Una lista de usuarios con membresía encontrados en la base de datos.
     */
    public List<ModeloUsuarioMembresia> buscarUsuario(){
        String configuracionPersistencia = "conexionBD";

        try(EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory(configuracionPersistencia);
            EntityManager entityManager = entityManagerFactory.createEntityManager()){


            //Establecer consulta para traer datos de la BD


            String jpqlConsulta = "SELECT usuario FROM ModeloUsuarioMembresia usuario";

            //
            List<ModeloUsuarioMembresia> usuariosBD =
                    entityManager.createQuery(jpqlConsulta, ModeloUsuarioMembresia.class).getResultList();

            //Retornar

            return usuariosBD;


        }catch (Exception e){
            System.out.println("Fallamos " + e.getMessage());
            return null;
        }

    }

}
