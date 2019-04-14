package UTN.clases;

import UTN.interfaces.IBeber;

public class BeberVikingoImp implements IBeber {

    @Override
    public int beber(Object luchador) {
        int fortaleza=-1;
        if (luchador instanceof Vikingo)
        {
            fortaleza=((Vikingo) luchador).getEdad()*((Vikingo) luchador).getPeso()*((Vikingo) luchador).getBebedorProfesional();
        }
        else{
            if(luchador instanceof DuenioTaberna){
                fortaleza=((DuenioTaberna) luchador).getEdad()*((DuenioTaberna) luchador).getPeso()*((DuenioTaberna) luchador).getBebedorProfesional();
            }
        }
        return fortaleza;
    }
}
