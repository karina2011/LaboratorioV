package UTN.clases;

public class DuenioTaberna extends Humano {
    private Integer toleranciaExtra;
    private Integer bebedorProfesional;
    public DuenioTaberna(String unNombre, Integer unaEdad, Integer unPeso,Integer toleranciaExtra,Integer bebedorProfesional) {
        super(unNombre, unaEdad, unPeso, new OrinarEspartanoImp(),new BeberVikingoImp());
        this.bebedorProfesional=bebedorProfesional;
        this.toleranciaExtra=toleranciaExtra;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }
}
