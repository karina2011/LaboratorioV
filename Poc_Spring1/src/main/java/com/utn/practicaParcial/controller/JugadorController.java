package com.utn.practicaParcial.controller;


import com.utn.practicaParcial.model.Equipo;
import com.utn.practicaParcial.model.Jugador;
import com.utn.practicaParcial.model.JugadorDTO;
import com.utn.practicaParcial.repositories.EquipoRepository;
import com.utn.practicaParcial.repositories.JugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/jugador")
@RestController
public class JugadorController {
    private static final String PERSON_NOT_FOUND = "No existe el jugador con el id: %s";
    private static final String TEAM_NOT_FOUND="No existe el equipo con ese id";
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    EquipoRepository equipoRepository;


    @PostMapping("")
    public String addJugador(@RequestBody @Valid final Jugador j, BindingResult result) {
        if (result.hasErrors()){
            return "CompletarNombreJugador";
        }
        jugadorRepository.save(j);
        return "IngresoNuevoJugador";
    }

    @GetMapping("")
    public List<Jugador> getAll() {
        return jugadorRepository.findAll();
    }

    /*@PostMapping("/{id}")
    public Jugador getEquipo(@PathVariable final Integer id){
        return (jugadorRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id))));
    }*/

    @PostMapping("/{id}")
    public JugadorDTO getEquipoDTO(@PathVariable final Integer id){
        Jugador unJugador=jugadorRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id)));
        ModelMapper mapper=new ModelMapper();
        return (mapper.map(unJugador, JugadorDTO.class));

    }
    @DeleteMapping("/{id}")
    public void deleteJugador (@PathVariable final Integer id){
        Jugador unJugador=jugadorRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id)));
        Equipo e=equipoRepository.findById(unJugador.getEquipo().getId()).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(TEAM_NOT_FOUND,unJugador.getEquipo().getId())));
        e.getJugadores().remove(unJugador);
        equipoRepository.save(e);
        jugadorRepository.delete(unJugador);
    }

    @PatchMapping("/{id}/{nombre}")
    public void updateJugador (@PathVariable final Integer id, @PathVariable final String nombre){
        Jugador unJugador=jugadorRepository.findById(id)
                .orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id)));
        unJugador.setNombre(nombre);
        jugadorRepository.save(unJugador);
    }
}
