package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.UsuarioPagoXEvento;
import org.example.modeloDatos.ModeloUsuario;
import org.example.modeloDatos.ModeloUsuarioXEvento;

import java.util.List;

public class ServicioUsuarioXEvento {

    public void registrarUsuario(UsuarioPagoXEvento usuarioPagoXEvento){
        String configuracionPersistencia = "conexionBD";

        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory(configuracionPersistencia);
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            ModeloUsuarioXEvento modeloUsuarioMembresia =
                    getModeloUsuarioMembresia(usuarioPagoXEvento);

            entityManager.getTransaction().begin();

            entityManager.persist(modeloUsuarioMembresia);

            entityManager.getTransaction().commit();

            System.out.println("Exito en la transacción. Usuario registrado exitosamente");

        } catch (Exception error) {
            System.out.println("Fallamos " + error.getMessage());
        }
    }

    private static ModeloUsuarioXEvento getModeloUsuarioMembresia(UsuarioPagoXEvento usuarioPagoXEvento) {
        ModeloUsuarioXEvento modeloUsuarioXEvento = new ModeloUsuarioXEvento();
        modeloUsuarioXEvento.setFk(new ModeloUsuario(
                usuarioPagoXEvento.getDocumento(),usuarioPagoXEvento.getNombres(),
                usuarioPagoXEvento.getCorreo(), usuarioPagoXEvento.getUbicacion()
        ));

        modeloUsuarioXEvento.setCostoPorEvento(usuarioPagoXEvento.getCostoPorEvento());


        return modeloUsuarioXEvento;
    }

    public List<ModeloUsuarioXEvento> buscarUsuario(){
        String configuracionPersistencia = "conexionBD";

        try(EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory(configuracionPersistencia);
            EntityManager entityManager = entityManagerFactory.createEntityManager()){


            String jpqlConsulta = "SELECT usuario FROM ModeloUsuarioXEvento usuario";

            //
            List<ModeloUsuarioXEvento> usuariosBD =
                    entityManager.createQuery(jpqlConsulta, ModeloUsuarioXEvento.class).getResultList();

            //Retornar

            return usuariosBD;


        }catch (Exception e){
            System.out.println("Fallamos " + e.getMessage());
            return null;
        }
    }
}
