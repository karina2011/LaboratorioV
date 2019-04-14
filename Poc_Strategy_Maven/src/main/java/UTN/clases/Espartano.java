package UTN.clases;

import UTN.interfaces.IBeber;
import UTN.interfaces.IOrinar;

public class Espartano extends Humano {
    private Integer toleranciaExtra;
    private int cantidadLiquido;

    public Espartano(String unNombre, Integer unaEdad, Integer unPeso, Integer toleranciaExtra) {
        super(unNombre, unaEdad, unPeso, new OrinarEspartanoImp(), new BeberEspartanoImp());
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

}
