package UTN.clases;

import UTN.interfaces.IOrinar;

public class OrinarVikingoImp implements IOrinar {

    @Override
    public int orinar(Object luchador) {
        int debilidad=-1;
        if (luchador instanceof Vikingo)
        {
            int mult=((Vikingo) luchador).getPeso()/10;
            debilidad =(int) Math.floor(Math.random()*mult);
        }
        return debilidad;
    }
}
