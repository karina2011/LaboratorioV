package com.utn.practicaParcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity

public class Jugador {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    @JsonIgnore
    private Equipo equipo;
}
