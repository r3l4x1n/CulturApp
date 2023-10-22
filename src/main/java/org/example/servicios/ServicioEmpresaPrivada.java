package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.EmpresaPrivada;
import org.example.modeloDatos.ModeloEmpresa;
import org.example.modeloDatos.ModeloEmpresaPrivada;

import java.util.List;

public class ServicioEmpresaPrivada {

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
