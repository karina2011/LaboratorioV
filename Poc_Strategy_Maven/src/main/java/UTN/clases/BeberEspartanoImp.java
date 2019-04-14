package UTN.clases;

import UTN.interfaces.IBeber;

public class BeberEspartanoImp implements IBeber {

    @Override
    public int beber(Object luchador) {
        int debilidad=-1;
        if (luchador instanceof Espartano)
        {
            int mult=((Espartano) luchador).getPeso()/10;
            debilidad =(int) Math.floor(Math.random()*mult);
        }
        return debilidad;
    }
}
