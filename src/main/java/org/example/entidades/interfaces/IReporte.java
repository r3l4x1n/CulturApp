package org.example.entidades.interfaces;

/**
 * Esta interfaz define operaciones para la generación, búsqueda, edición y eliminación de informes o reportes.
 */
public interface IReporte {

    /**
     * Genera un reporte utilizando los datos proporcionados.
     *
     * @param datos Los datos a utilizar para generar el reporte.
     */
    void generarReporte(String datos );

    /**
     * Busca un reporte utilizando un identificador específico.
     *
     * @param id El identificador del reporte a buscar.
     */
    void buscarReporte(Integer id);

    /**
     * Edita un reporte identificado por su ID.
     *
     * @param id El identificador del reporte a editar.
     */
    void editarReporte(Integer id);

    /**
     * Elimina un reporte identificado por su ID. Este método tiene una implementación por defecto que imprime un mensaje.
     *
     * @param identidicacion El identificador del reporte a eliminar.
     */
    default void eliminarReporte(Integer identidicacion){
        System.out.println("Reporte eliinado");
    }


}
