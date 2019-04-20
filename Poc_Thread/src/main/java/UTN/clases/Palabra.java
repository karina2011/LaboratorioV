package UTN.clases;

import UTN.Daos.PalabraDao;

public class Palabra {
    String palabra;
    char[] palabraChar;
    PalabraDao palabraDao;
    private final int TIEMPOESPERA = 1500;

    /**
     * Constructor de la clase palabra con una palabra aleatoria de la base de datos
     */

    public Palabra() {
        this.palabraDao=new PalabraDao ();
        this.palabra=buscarPalabraDao ();
        this.palabraChar=palabra.toCharArray ();
    }

    /**
     * Constructor para jugar con una palabra ingresada desde teclado y no desde la base de datos
     * @param unaPalabra
     */
    public Palabra (String unaPalabra){
        palabraDao=new PalabraDao ();
        palabra=unaPalabra;
    }
    /**
     * Metodo getPalabra retorna la palabra
     * @return palabra
     */
    public String getPalabra() {

        return palabra;
    }

    /**
     *  Metodo buscarPalbra invoca al metodo read de la base de
     *  datos de palabra que no retorna una palabra aleatoria de la base de datos
     * @return unaPlabra
     */
    public String buscarPalabraDao() {
        return palabraDao.read ();
    }

    /**
     * Metodo agregarPalabraDao recibe una palabra como parametro y la envia al metodo create de la base de datos de
     * palabra para que la agregue a la base de datos
     * @param unaPalabra
     */
    public void agregarPalabraDao(String unaPalabra){
        palabraDao.create ( unaPalabra );
    }

    /**
     * Metodo stringToChat convierte la palabra de tipo String en un arreglo de char
     * @return arreglo
     */
    public char[] stringToChar ()
    {
        char[] arreglo=new char[palabra.length()];
        arreglo=palabra.toCharArray();
        return arreglo;
    }


    /**
     * Retorna la cantidad de veces que aparece la letra en la palabra, ambas pasadas por parametro
     * @param letra
     * @return cont
     */
    public int cantidadRepeaticiones(char letra){
        String palabraLetra=Character.toString(letra);
        int cont=0;
        if (palabra.contains(palabraLetra)){
            for (int i=0;i<palabraChar.length;i++) {
                if(palabraChar[i]==letra){
                    cont++;
                }
            }
        }
        return cont;
    }

    /**
     * Metodo reemplazarLetra Por cada vez que aparezca la letra en la plabra pasadas por para metros la reemplaza
     * por un asterisco
     * @param letra
     * @return unaPalabra
     */
    public char[] reemplazarLetra(char letra){
        for (int i=0;i<palabraChar.length;i++){
            if(palabraChar[i]==letra){
                palabraChar[i]='*';
            }
        }
        //palabra = palabra.replace ( letra, '*' );
        return palabraChar;
    }

    /**
     * Metodo tieneLetrasArreglo retorna true si el arreglo tiene letras sin adivinar y false en caso contrario
     * @return tiene
     */
    public boolean tieneLetras ()
    {
        boolean tiene=false;
        int i=0;
        while ((i<palabraChar.length)&&(!tiene)){
            if(palabraChar[i]!='*'){
                tiene=true;
            }
            i++;
        }
        return tiene;
    }
}
