package UTN.clases;

import UTN.interfaces.IBeber;
import UTN.interfaces.IOrinar;

public class Humano {
    private String nombre;
    private Integer edad;
    private Integer peso;
    private IOrinar orinar;
    private IBeber beber;

    public Humano(String unNombre, Integer unaEdad, Integer unPeso,IOrinar unOrinar,IBeber unBeber) {
        nombre = unNombre;
        edad = unaEdad;
        peso = unPeso;
        orinar=unOrinar;
        beber=unBeber;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public IOrinar getOrinar() {
        return orinar;
    }

    public IBeber getBeber() {
        return beber;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" Edad: "+edad+" peso: "+peso;
    }
}
