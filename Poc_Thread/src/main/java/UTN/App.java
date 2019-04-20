package UTN;

import UTN.Daos.GanadoresDao;
import UTN.clases.Ahorcado;
import UTN.clases.Ganador;
import UTN.clases.Jugador;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Ahorcado ahorcado;
    private static Thread [] jugadores;
    private static final int CANTIDADJUGADORES = 2;

    public static void main( String[] args )
    {

        //Palabra unaPalbra=new Palabra ();
        //unaPalbra.agregarPalabraDao ( "computadora" );
        //System.out.println ( unaPalbra.getPalabra () );
                ahorcado = new Ahorcado ();
        jugadores = new Thread[CANTIDADJUGADORES];
        for(int i = 0; i < CANTIDADJUGADORES; i++)
        {
            String nombre="jugador"+i;
            jugadores[i] = new Thread(new Jugador (ahorcado,nombre));
            jugadores[i].start();
        }
        //jugadores[0].start ();
        //jugadores[1].start ();

        GanadoresDao ganadorDao= new GanadoresDao (  );
        Ganador ultimoGanador= ganadorDao.read ();
        System.out.println ("Nombre: "+ ultimoGanador.getNombre ()+" palabra: "+ ultimoGanador.getPalabra ()+" fecha: " +ultimoGanador.getFecha () );

    }
}
