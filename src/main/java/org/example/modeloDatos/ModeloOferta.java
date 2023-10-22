package org.example.modeloDatos;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ModeloOferta {



    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private Integer id;

    @Column(name = "titulo",nullable = false)
    private String titulo;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio",nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin",nullable = false)
    private LocalDate fechaFin;

    @Column(name = "costo_persona",nullable = false)
    private Double costoPersona;

    @Column(name = "id_empresa",nullable = false)
    private Integer idEmpresa;
}
