import clases.City;
import clases.Event;
import clases.GoToEvent;
import clases.Location;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args){
        GoToEvent eventos=new GoToEvent();
        Event unEvento= new Event (1,"No te va a gustar",new Location(1,"platea",new City(1,"Mar del Plata")));
        eventos.add(unEvento);
        unEvento= new Event (6,"Callejeros",new Location(6,"platea",new City(6,"Mar del Plata")));
        eventos.add(unEvento);
        unEvento= new Event (4,"La Beriso",new Location(4,"platea",new City(4,"Mar del Plata")));
        eventos.add(unEvento);
        unEvento= new Event (8,"HaAsh",new Location(8,"platea",new City(8,"Tandil")));
        eventos.add(unEvento);
        unEvento= new Event (3,"Sebastian Yatra",new Location(3,"platea",new City(3,"Tandil")));
        eventos.add(unEvento);
        unEvento= new Event (10,"The Beatle",new Location(10,"platea",new City(10,"Buenos Aires")));
        eventos.add(unEvento);
        unEvento=new Event();
        unEvento.setB(16,"builder",new Location().setB(16,"culaquiera",new City().setB(16,"mdq")));
        eventos.add(unEvento);
        System.out.println("\ntodos los eventos");
        eventos.listEvent();

        System.out.println("\nLos eventos ordenados por id");
        eventos.getOrdenarId();
        eventos.listEvent();

        System.out.println("\nlos primeros cinco eventos");
        List<Event> firstFive = eventos.listFirstFiveEvent();
        firstFive.forEach((e)->System.out.println((e.getName())));

        System.out.println("\nun evento por id");
        System.out.println(eventos.eventForId(1));

        System.out.println("\nLos eventos ordenados alfabeticamente");
        eventos.getOrdenarAlfa();
        eventos.listEvent();
    }
}
