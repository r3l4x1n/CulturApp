package org.example.entidades.interfaces;

/**
 * Esta interfaz representa un contrato para realizar análisis de datos y calcular la dispersión de los mismos.
 *
 * @param <T> El tipo de datos que se analizará.
 */
public interface IAnalitica <T> {

    /**
     * Limpia los datos proporcionados.
     *
     * @param datos Los datos que se van a limpiar.
     */

    void limpiarDatos(T datos);

    /**
     * Calcula la dispersión de los datos proporcionados.
     *
     * @param datos Los datos para los cuales se calculará la dispersión.
     */
    void calcularDispersion(T datos);

}
