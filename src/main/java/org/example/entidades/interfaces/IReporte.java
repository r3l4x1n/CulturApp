package org.example.entidades.interfaces;

public interface IReporte {

    void generarReporte(String datos );

    void buscarReporte(Integer id);

    void editarReporte(Integer id);

    default void eliminarReporte(Integer identidicacion){
        System.out.println("Reporte eliinado");
    }


}
