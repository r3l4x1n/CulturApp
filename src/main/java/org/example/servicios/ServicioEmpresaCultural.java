package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.EmpresaCultural;
import org.example.modeloDatos.ModeloEmpresa;
import org.example.modeloDatos.ModeloEmpresaCultural;

import java.util.List;

/**
 * Este servicio proporciona métodos para registrar y buscar empresas culturales en la base de datos.
 */
public class ServicioEmpresaCultural {

    /**
     * Registra una empresa cultural en la base de datos.
     *
     * @param empresaCultural La empresa cultural que se va a registrar.
     */
    public void registrarEmpresa(EmpresaCultural empresaCultural){
        String configuracionPersistencia = "conexionBD";

        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory(configuracionPersistencia);
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            ModeloEmpresaCultural modeloEmpresaCultural =
                    getModeloEmpresaCultural(empresaCultural);


            entityManager.getTransaction().begin();

            entityManager.persist(modeloEmpresaCultural);

            entityManager.getTransaction().commit();

            System.out.println("Exito en la transacción. empresa registrada exitosamente");

        } catch (Exception error) {
            System.out.println("Fallamos " + error.getMessage());
        }
    }

    /**
     * Convierte una instancia de la clase `EmpresaCultural` en una instancia de `ModeloEmpresaCultural`.
     *
     * @param empresaCultural La empresa cultural que se va a convertir.
     * @return La instancia de `ModeloEmpresaCultural` creada a partir de la empresa cultural.
     */
    private static ModeloEmpresaCultural getModeloEmpresaCultural(EmpresaCultural empresaCultural) {
        ModeloEmpresaCultural modeloEmpresaCultural = new ModeloEmpresaCultural();
        modeloEmpresaCultural.setFk(new ModeloEmpresa(
                empresaCultural.getNit(),
                empresaCultural.getNombre(),
                empresaCultural.getUbicacion(),
                empresaCultural.getDescripcion()
        ));

        modeloEmpresaCultural.setEntidad(empresaCultural.getEntidad());
        modeloEmpresaCultural.setEmailContacto(empresaCultural.getEmailContacto());
        modeloEmpresaCultural.setNumeroContacto(empresaCultural.getNumeroContacto());
        modeloEmpresaCultural.setMision(empresaCultural.getMision());


        return modeloEmpresaCultural;
    }

    /**
     * Busca y devuelve una lista de empresas culturales en la base de datos.
     *
     * @return Una lista de empresas culturales encontradas en la base de datos.
     */
    public List<ModeloEmpresaCultural> buscarEmpresa(){
        String configuracionPersistencia = "conexionBD";

        try(EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory(configuracionPersistencia);
            EntityManager entityManager = entityManagerFactory.createEntityManager()){

            String jpqlConsulta = "SELECT empresa FROM ModeloEmpresaCultural empresa";

            //
            List<ModeloEmpresaCultural> empresasBD =
                    entityManager.createQuery(jpqlConsulta, ModeloEmpresaCultural.class).getResultList();

            //Retornar

            return empresasBD;


        }catch (Exception e){
            System.out.println("Fallamos " + e.getMessage());
            return null;
        }
    }


}
