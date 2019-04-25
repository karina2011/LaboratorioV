package UTN.clases;


import UTN.Daos.GanadoresDao;

import java.util.Date;

public class Jugador implements Runnable {
    static final int CANT_VIDAS = 15;
    static boolean gano=Boolean.FALSE;
    private int cantVidas;
    private String nombre;
    private Ahorcado ahorcado;
    private final int TIEMPOESPERA = 1500;
    private Ganador ganador;
    private GanadoresDao ganadorDao;

    /**
     * Constructo de la clase jugador
     * @param nombre
     */
    public Jugador(Ahorcado ahorcado, String nombre) {
        this.nombre = nombre;
        this.ahorcado=ahorcado;
        cantVidas=CANT_VIDAS;
        ganador=null;
        ganadorDao=new GanadoresDao ();
    }


    /**
     * Devuelve la cantidad de vidas
     * @return cantVidas
     */
    public int getCantidadVidas(){
        return cantVidas;
    }


    /**
     * Metodo getNombre que retorna el nombre del jugador
     * @return
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getAhorcado retorna el atributo ahorcado
     * @return
     */
    public Ahorcado getAhorcado(){
        return ahorcado;
    }

    /**
     * Metodo run en donde selecciona una letra aleatroriamente del abecedario y si coincide con alguna de la palabra
     * la elimina del abecedario y de la palabra. Ademas analiza si perdio o gano en cada jugada, en tal caso envia un msendaje
     */
    @Override
    public void run() {
        boolean adivino= Boolean.FALSE;
        while ((getCantidadVidas () >= 0) && (!gano)) {
            adivino = ahorcado.jugarAhorcado ();
            if ((adivino) && (!ahorcado.getPalabra ().tieneLetras ())) {
                gano = Boolean.TRUE;
                System.out.println ( "el ganador es: " + nombre );
                ganador = new Ganador ( nombre, ahorcado.getPalabra ().getPalabra (), new Date () );
                ganadorDao.create ( ganador );
            } else {
                cantVidas--;
                if (getCantidadVidas () < 0) {
                    System.out.println ( "perdio por quedarse sin vidas: " + nombre );
                } else {
                    if (!ahorcado.getPalabra ().tieneLetras ()) {
                        System.out.println ( "perdio: " + nombre );
                    }
                }
            }
        }
        try
        {
            Thread.sleep(TIEMPOESPERA);
        }
            catch (InterruptedException e)
        {
            System.err.println("Jugador " + nombre + ": Error en run -> " + e.getMessage());
        }
    }
}

