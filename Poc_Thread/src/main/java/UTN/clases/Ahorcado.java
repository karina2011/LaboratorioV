package UTN.clases;


import java.util.ArrayList;
import java.util.List;

public class Ahorcado {
    private Palabra palabra;
    private boolean juegoOcupado;
    private List<Character> abecedario;

    /**
     * Construvtor de la clase Ahorcado que crea la palabra, genera el abecedario e inicializa una variable boolean
     */
    public Ahorcado (){
        palabra=new Palabra ( );
        juegoOcupado= Boolean.FALSE;
        this.abecedario=getAbecedario ();

    }

    /**
     * Metodo getAbecedario genera una lista de Charcter que contienen todas las letras del abecedario
     * @return
     */
    public List<Character> getAbecedario ()
    {
        String abc="abcdefghijklmnopqrstuvwxyz";
        List<Character> abecedario= new ArrayList<> (  );
        for (int i=0;i<abc.length ();i++){
            abecedario.add (abc.charAt(i));
        }
        return abecedario;
    }

    /**
     * Metoso elegirAleatorioLetra selecciona del abecesdario una letra aleatroriamente
     * @return unaLetra
     */
    public char elegirAleatorioLetra(){

        int i=(int)(Math.random()*abecedario.size());
        char unaLetra =abecedario.get ( i );
        abecedario.remove ( i );
        return unaLetra;
    }


    /**
     * Metodo getPalabra retorna la palabra con la que se esta jugando
     * @return
     */
    public Palabra getPalabra(){
        return palabra;
    }

    /**
     * Metodo jugarAhorcado es el encargado de administrar la zona critica que en este caso es el
     * acceso a la palabra para poder jugar los digerentes jugadores
     * @return adivino
     */

    public synchronized Boolean jugarAhorcado()
    {
        while (juegoOcupado)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }

        juegoOcupado = Boolean.TRUE;

        boolean adivino=Boolean.FALSE;
        if (palabra.tieneLetras ())
        {
            char letra= elegirAleatorioLetra ();
            if (palabra.cantidadRepeaticiones ( letra )>0) {
                palabra.reemplazarLetra ( letra );
                adivino = Boolean.TRUE;
            }
        }

        juegoOcupado=Boolean.FALSE;

        notify();
        return adivino;
    }
}


