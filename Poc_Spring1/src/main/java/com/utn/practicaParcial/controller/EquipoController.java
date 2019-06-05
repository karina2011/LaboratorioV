package com.utn.practicaParcial.controller;

import com.utn.practicaParcial.model.Equipo;
import com.utn.practicaParcial.model.Jugador;
import com.utn.practicaParcial.repositories.EquipoRepository;
import com.utn.practicaParcial.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/equipo")
@RestController
public class EquipoController {
    private static final String TEAM_NOT_FOUND = "No existe el equipo con el id: %s";
    private static final String PERSON_NOT_FOUND="No existe la persona con el id:  %s";
    @Autowired//permite indicar en qué variable inyectar una dependencia
            EquipoRepository equipoRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    

    @PostMapping("")
    public String addEquipo(@RequestBody @Valid final Equipo e, BindingResult result) {
        if (result.hasErrors())
        {
            return "CompletarNombreEquipo";
        }
        equipoRepository.save(e);
        return "IngresoNuevoEquipo";
    }

    @GetMapping("")
    public List<Equipo> getAll(@RequestHeader HttpHeaders header) {
        System.out.println("header: " + header.getHost());
        System.out.println("user-agent:  " + header.get("user-agent"));
        System.out.println("postman-token:  "+header.get("postman-token"));
        System.out.println("content-type: "+ header.get("content-type"));
        System.out.println("cache-control" + header.get("cache-control"));
        return equipoRepository.findAll();
    }

    @PostMapping("/{id}")
    public Equipo getEquipo(@PathVariable final Integer id){
        return (equipoRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(TEAM_NOT_FOUND,id))));
    }

    @PostMapping("/{id}/{idJugador}")
    public void addJugadorEquipo(@PathVariable final Integer id, @PathVariable final Integer idJugador){
        Jugador j=jugadorRepository.findById (idJugador).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,idJugador)));
        Equipo e=equipoRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(TEAM_NOT_FOUND,id)));
        e.getJugadores().add(j);
        equipoRepository.save(e);
        j.setEquipo(e);
        jugadorRepository.save(j);
    }

    @DeleteMapping ("{id}")
    public void deleteEquipo (@PathVariable final Integer id){
        Equipo e=equipoRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(TEAM_NOT_FOUND,id)));
        List<Jugador> jugadores=jugadorRepository.findAll();
        jugadores.stream().filter(j->j.getEquipo()!=null).filter(j->j.getEquipo().getId()==id).forEach(jugador -> jugador.setEquipo(null));
        jugadorRepository.saveAll(jugadores);
        System.out.println();
        equipoRepository.delete(e);
    }
}
