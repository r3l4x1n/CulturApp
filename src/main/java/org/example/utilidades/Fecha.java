package org.example.utilidades;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {

    public static LocalDate formatearFecha(String fecha){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nuevaFecha = LocalDate.parse(fecha,formatter);
        return nuevaFecha;

    }





}
