package UTN;

import UTN.Daos.Conexion;
import UTN.Daos.DaoGanador;
import UTN.clases.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Humano> vikingos=new ArrayList<>();
        List<Humano> espartanos=new ArrayList<>();
        /*vikingos= Arrays.asList(new Vikingo("Santino",30,60,50),
                                new Vikingo("Dominick",27,68,20),
                                new Vikingo("Matias",30,70,30),
                                new Vikingo("Mariela",34,65,25),
                                new Vikingo("Karina",30,72,60));
        espartanos=Arrays.asList(new Espartano("Gonzalo",30,75,50),
                                new Espartano("German",15,73,20),
                                new Espartano("Pablo",18,78,30),
                                new Espartano("Gonzalo",30,75,30),
                                new Espartano("Nacho",18,80,50));*/
        Humano unVikingo=new Vikingo("Santino",30,60,50);
        vikingos.add(unVikingo);
        unVikingo=new Vikingo("Dominick",27,68,20);
        vikingos.add(unVikingo);
        unVikingo=new Vikingo("Matias",30,70,30);
        vikingos.add(unVikingo);
        unVikingo=new Vikingo("Mariela",34,65,25);
        vikingos.add(unVikingo);
        unVikingo=new Vikingo("Karina",30,72,60);
        vikingos.add(unVikingo);

        Humano unEspartano=new Espartano("Gonzalo",30,60,50);
        espartanos.add(unEspartano);
        unEspartano=new Espartano("German",27,68,20);
        espartanos.add(unEspartano);
        unEspartano=new Espartano("Pablo",30,70,30);
        espartanos.add(unEspartano);
        unEspartano=new Espartano("Lucas",34,65,25);
        espartanos.add(unEspartano);
        unEspartano=new Espartano("Nacho",30,72,60);
        espartanos.add(unEspartano);

        JuegoEspartanoVikingo unJuego=new JuegoEspartanoVikingo(vikingos,espartanos);
        System.out.println("Acontinuacion se presentan los jugadores ordenados por edad\nLOS VIKINGOS:");
        unJuego.ordenarLista(vikingos);
        unJuego.mostarLista(vikingos);
        System.out.println("\nLOS ESPARTANOS:");
        unJuego.ordenarLista(espartanos);
        unJuego.mostarLista(espartanos);
        Humano resultado=unJuego.jugarCompleto();
        System.out.println("\nGanador:\n"+resultado.toString());
        Humano duenioTaberna=new DuenioTaberna("Fino",30,72,20,30);
        resultado=unJuego.rondaFinal(duenioTaberna,resultado);
        System.out.println("\nEl ganador de la ronda Final:\n"+resultado.toString());

        Conexion conn=new Conexion();
        conn.conectar();
        DaoGanador dao=new DaoGanador(conn);
        dao.CargarGanador(resultado);
        System.out.println("\nBASE DE DATOS\ntabla de todos los ganadores");
        dao.mostrarGanadores();
        System.out.println ("\nEl ultimo ganador registrado:");
        dao.mostrarUltimoGanador();
        conn.cerrarConexion();
    }
}
