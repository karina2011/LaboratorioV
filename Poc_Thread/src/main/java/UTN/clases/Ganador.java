package UTN.clases;

import java.util.Date;

public class Ganador {
    private String nombre;
    private String palabra;
    private Date fecha;

    public Ganador() {
        nombre="";
        palabra="";
        fecha=null;
    }

    public Ganador(String nombre, String palabra, Date fecha) {
        this.nombre = nombre;
        this.palabra = palabra;
        this.fecha = fecha;
    }


    public String getNombre() {
        return nombre;
    }

    public String getPalabra() {
        return palabra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
