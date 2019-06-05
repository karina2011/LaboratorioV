package com.utn.practicaParcial.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity

public class Equipo {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nombreEquipo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<Jugador> jugadores;
}
