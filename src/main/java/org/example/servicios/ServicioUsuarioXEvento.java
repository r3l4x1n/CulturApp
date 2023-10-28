package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.UsuarioPagoXEvento;
import org.example.modeloDatos.ModeloUsuario;
import org.example.modeloDatos.ModeloUsuarioXEvento;

import java.util.List;

/**
 * Este servicio proporciona métodos para registrar y buscar usuarios que participan en eventos y realizan pagos por evento en la base de datos.
 */
public class ServicioUsuarioXEvento {

    /**
     * Registra un usuario que participa en un evento y realiza un pago por evento en la base de datos.
     *
     * @param usuarioPagoXEvento El usuario que se va a registrar.
     */
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

    /**
     * Convierte una instancia de la clase `UsuarioPagoXEvento` en una instancia de `ModeloUsuarioXEvento`.
     *
     * @param usuarioPagoXEvento El usuario que se va a convertir.
     * @return La instancia de `ModeloUsuarioXEvento` creada a partir del usuario que participa en eventos y realiza pagos por evento.
     */
    private static ModeloUsuarioXEvento getModeloUsuarioMembresia(UsuarioPagoXEvento usuarioPagoXEvento) {
        ModeloUsuarioXEvento modeloUsuarioXEvento = new ModeloUsuarioXEvento();
        modeloUsuarioXEvento.setFk(new ModeloUsuario(
                usuarioPagoXEvento.getDocumento(),usuarioPagoXEvento.getNombres(),
                usuarioPagoXEvento.getCorreo(), usuarioPagoXEvento.getUbicacion()
        ));

        modeloUsuarioXEvento.setCostoPorEvento(usuarioPagoXEvento.getCostoPorEvento());


        return modeloUsuarioXEvento;
    }

    /**
     * Busca y devuelve una lista de usuarios que participan en eventos y realizan pagos por evento en la base de datos.
     *
     * @return Una lista de usuarios encontrados en la base de datos.
     */
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
