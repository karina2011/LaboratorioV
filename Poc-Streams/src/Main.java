import clases.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Persona> personas= new ArrayList<>();
        personas= Arrays.asList(new Persona("Karina",29101068,35),
                                new Persona("Mariela",29333333,36),
                                new Persona ("Santino",7000000,7),
                                new Persona ("German",25000000,20),
                                new Persona("Gonzalo",7000000,22));
        System.out.println(String.format("Personas mayores a 21 :\n %s", personas.stream()
                        .filter(persona->persona.getEdad()>21)
                        .collect(Collectors.toList())));
        System.out.println(String.format("Personas con Dni mayor a 10000000:\n %s", personas.stream()
                .filter(persona->persona.getDni()>10000000)
                .collect(Collectors.toList())));
        System.out.println(String.format("Personas mayores a 21 y con dni mayor a 10000000: %s", personas.stream()
                .filter(persona->persona.getEdad()>21)
                .filter(persona->persona.getDni()>10000000 )
                .collect(Collectors.toList())));
    }
}
