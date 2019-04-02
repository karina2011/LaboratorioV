package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class GoToEvent {
    List<Event> eventos=null;

    public GoToEvent() {

        this.eventos = new ArrayList<>();
    }

    public List<Event> getEventos() {
        return eventos;
    }

    public List<Event> getOrdenar (){
        eventos.sort(comparingInt(Event::getId));
        return eventos;
    }


    public void add(Event unEvento) {

        eventos.add(unEvento);
    }

    public List<Event> listFirstFiveEvent()
    {
        //no me tira un npe si son menos de cinco objetos
        List<Event> firstFive= eventos.stream().limit(5).collect(Collectors.toList());
        return firstFive;
    }

    public void listEvent()
    {
        eventos.forEach((e)->System.out.println((e.getName())));
    }

    public Event eventForId (int oneId){
        Optional<Event> oneEvent= eventos.stream()
                                .filter(e->e.getId()==oneId)
                                .findFirst();
        return oneEvent.isPresent() ? oneEvent.get() : null;
    }

}
