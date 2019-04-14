package UTN.clases;

import UTN.interfaces.IOrinar;

public class OrinarEspartanoImp implements IOrinar {

    public int orinar(Object luchador) {
        int fortaleza=-1;
        if (luchador instanceof Espartano)
        {
            fortaleza=((Espartano) luchador).getEdad()*((Espartano) luchador).getPeso()*((Espartano) luchador).getToleranciaExtra();
        }
        else{
            if(luchador instanceof DuenioTaberna) {
                fortaleza = ((DuenioTaberna) luchador).getEdad() * ((DuenioTaberna) luchador).getPeso() * ((DuenioTaberna) luchador).getToleranciaExtra();
            }
        }
        return fortaleza;
    }
}
