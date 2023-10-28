package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.EmpresaPrivada;
import org.example.modeloDatos.ModeloEmpresa;
import org.example.modeloDatos.ModeloEmpresaPrivada;

import java.util.List;

/**
 * Este servicio proporciona métodos para registrar y buscar empresas privadas en la base de datos.
 */
public class ServicioEmpresaPrivada {

    /**
     * Registra una empresa privada en la base de datos.
     *
     * @param empresaPrivada La empresa privada que se va a registrar.
     */
    public void registrarEmpresa(EmpresaPrivada empresaPrivada){
        String configuracionPersistencia = "conexionBD";

        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory(configuracionPersistencia);
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            ModeloEmpresaPrivada modeloEmpresaPrivada =
                    getModeloEmpresaCultural(empresaPrivada);


            entityManager.getTransaction().begin();

            entityManager.persist(modeloEmpresaPrivada);

            entityManager.getTransaction().commit();

            System.out.println("Exito en la transacción. empresa registrada exitosamente");

        } catch (Exception error) {
            System.out.println("Fallamos " + error.getMessage());
        }
    }

    /**
     * Convierte una instancia de la clase `EmpresaPrivada` en una instancia de `ModeloEmpresaPrivada`.
     *
     * @param empresaPrivada La empresa privada que se va a convertir.
     * @return La instancia de `ModeloEmpresaPrivada` creada a partir de la empresa privada.
     */
    private static ModeloEmpresaPrivada getModeloEmpresaCultural(EmpresaPrivada empresaPrivada) {
        ModeloEmpresaPrivada modeloEmpresaPrivada = new ModeloEmpresaPrivada();
        modeloEmpresaPrivada.setFk(new ModeloEmpresa(
                empresaPrivada.getNit(),
                empresaPrivada.getNombre(),
                empresaPrivada.getUbicacion(),
                empresaPrivada.getDescripcion()
        ));

        modeloEmpresaPrivada.setRepresentanteLegal(empresaPrivada.getRepresentanteLegal());
        modeloEmpresaPrivada.setCedula(empresaPrivada.getCedula());

        return modeloEmpresaPrivada;
    }

    /**
     * Busca y devuelve una lista de empresas privadas en la base de datos.
     *
     * @return Una lista de empresas privadas encontradas en la base de datos.
     */
    public List<ModeloEmpresaPrivada> buscarEmpresa(){
        String configuracionPersistencia = "conexionBD";

        try(EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory(configuracionPersistencia);
            EntityManager entityManager = entityManagerFactory.createEntityManager()){

            String jpqlConsulta = "SELECT empresa FROM ModeloEmpresaPrivada empresa";

            //
            List<ModeloEmpresaPrivada> empresasBD =
                    entityManager.createQuery(jpqlConsulta, ModeloEmpresaPrivada.class).getResultList();

            //Retornar

            return empresasBD;


        }catch (Exception e){
            System.out.println("Fallamos " + e.getMessage());
            return null;
        }
    }

}
