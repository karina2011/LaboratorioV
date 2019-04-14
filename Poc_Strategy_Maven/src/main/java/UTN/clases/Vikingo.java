package UTN.clases;

import UTN.interfaces.IBeber;
import UTN.interfaces.IOrinar;

public class Vikingo extends Humano {
    private Integer bebedorProfesional;

    public Vikingo(String unNombre, Integer unaEdad, Integer unPeso, Integer toleranciaExtra) {
        super(unNombre, unaEdad, unPeso,new OrinarVikingoImp(), new BeberVikingoImp());
        this.bebedorProfesional=toleranciaExtra;
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }
}
