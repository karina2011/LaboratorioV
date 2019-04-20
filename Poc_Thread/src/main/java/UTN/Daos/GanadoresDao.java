package UTN.Daos;

import UTN.Interfaces.ICrud;
import UTN.clases.Ganador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GanadoresDao implements ICrud<Ganador> {
    Conexion conn;


    public GanadoresDao() {
        conn=new Conexion ();
    }

    @Override
    public void create(Ganador ganador) {
        try {
            conn.conectar ("ganadores");
            java.util.Date d = new java.util.Date();
            java.sql.Date date2 = new java.sql.Date(d.getTime());
            String query="INSERT INTO jugadores (nombre, palabra, fecha) values (?,?,?)";
            PreparedStatement pst=conn.crearPst ( query );
            pst.setString ( 1,ganador.getNombre () );
            pst.setString ( 2,ganador.getPalabra ());
            pst.setDate (3, date2 );
            pst.executeUpdate ();
            conn.cerrarPst ( pst );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
            System.out.println ( "No se pudo ingresar la palabra" );
        }
    }

    @Override
    public Ganador read() {
        Ganador ganador=new Ganador();
        try {
            conn.conectar ("ganadores");
            String query="SELECT * FROM jugadores limit 1";
            Statement st=conn.crearst ();
            ResultSet rs= st.executeQuery ( query );
            if (rs.next()){
                ganador.setNombre(rs.getString ( "nombre" ));
                ganador.setPalabra(rs.getString ( "palabra" ));
                ganador.setFecha(rs.getDate ( "fecha" ));
            }
            conn.cerrarRs ( rs );
            conn.cerrarStsement ( st );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return ganador;
    }

    @Override
    public void update(Ganador oldJugador, Ganador newJugador) {

    }

    @Override
    public void delete(Ganador ganador) {
        try {
            conn.conectar ("ganadores");
            String query="DELETE FORM jugadores WHERE jugador.nombre=?)";
            PreparedStatement pst=conn.crearPst ( query );
            pst.setString ( 1,ganador.getNombre ());
            pst.executeUpdate ();
            conn.cerrarPst ( pst );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }

    }
}
