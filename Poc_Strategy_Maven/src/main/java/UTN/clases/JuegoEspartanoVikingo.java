package UTN.clases;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class JuegoEspartanoVikingo<T> {

    private List<Humano> vikingos;
    private List<Humano> espartanos;
    private List<String> resultados;

    public JuegoEspartanoVikingo(List<Humano> vikingos, List<Humano> espartanos) {
        this.vikingos=vikingos;
        this.espartanos=espartanos;
        this.resultados=new ArrayList<>();
    }


    public int jugarEspartano(Humano unEspartano) {
        int valor = -1;
        if (!espartanos.isEmpty()) {
            valor = unEspartano.getOrinar().orinar(unEspartano)-unEspartano.getBeber().beber(unEspartano);
            if (valor<0)
                valor=0;
            espartanos.remove(unEspartano);
        }
        return valor;
    }

    public Humano obtenerJugadorParaCompetir(List<Humano>unaLista){
        return unaLista.get((int)Math.floor(Math.random()*unaLista.size()));
    }

    public int jugarVikingo(Humano unVikingo) {
        int valor = -1;

        if (!vikingos.isEmpty()) {

            valor = unVikingo.getBeber().beber(unVikingo) - unVikingo.getOrinar().orinar(unVikingo);
            if (valor<0)
                valor=0;
            vikingos.remove(unVikingo);
        }
        return valor;
    }

    public int jugarDuenio(Humano duenio){
        int valor=0;
        if (duenio!=null){
            valor=duenio.getBeber().beber(duenio)-duenio.getOrinar().orinar(duenio);
        }
        return valor;
    }


    public List<Humano> jugarRonda() {
        List<Humano> competidores=new ArrayList<>();
        Humano h1=obtenerJugadorParaCompetir(vikingos);
        Humano h2=obtenerJugadorParaCompetir(espartanos);
        competidores.add(h1);
        competidores.add(h2);
        int resultadoVikingo = jugarVikingo(h1);
        int resultadoEspartano = jugarEspartano(h2);
        if (resultadoEspartano > resultadoVikingo) {
            vikingos.add(h1);
        } else {
            if (resultadoEspartano < resultadoVikingo) {
                espartanos.add(h2);
            } else {
                    espartanos.add(h2);
                    vikingos.add(h1);
              }
        }
        return competidores;
    }

    public Humano jugarCompleto()
    {
        List<Humano>competidores;
        while (!vikingos.isEmpty() && !espartanos.isEmpty()){
            competidores=jugarRonda();
            System.out.println("\nCompetidores de esta ronda:");//solo esta para que se vean los datos en forma mas clara
            mostarLista(competidores);
        }
        if(vikingos.isEmpty())
            return espartanos.get(0);
        else
            return vikingos.get(0);
    }

    public Humano rondaFinal(Humano duenio,Humano vikiEspart){
        int resul=0;
        Humano ganador=null;
        if (vikiEspart instanceof Vikingo){
            vikingos.add(vikiEspart);
            resul=jugarVikingo(vikiEspart)-jugarDuenio(duenio);
        }
        else{
            if (vikiEspart instanceof Espartano){
                espartanos.add(vikiEspart);
                resul=jugarEspartano(vikiEspart)-jugarDuenio(duenio);
            }
        }
        if(resul>0)
            ganador=duenio;
        else
            if(resul<0){
            ganador=vikiEspart;
            }
        return ganador;
    }

    public void ordenarLista(List<Humano>unaLista){
        //return unaLista.stream().sorted().collect(Collectors.toList());
        unaLista.sort(Comparator.comparing(Humano::getEdad));
    }

    public void mostarLista(List<Humano> unaLista){
        unaLista.forEach((h) -> System.out.println(h.toString()));
    }


}