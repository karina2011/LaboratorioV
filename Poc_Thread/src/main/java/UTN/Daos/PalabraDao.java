package UTN.Daos;

import UTN.Interfaces.ICrud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PalabraDao implements ICrud <String> {
    private Conexion conn;

    /**
     * Metodo constructor que crea una instancia de la clase conexion
     */
    public PalabraDao() {
        this.conn = new Conexion ();
    }

    /**
     * Metodo create inserta una nueva palabra a la base de datos
     * @param unaPalabra
     */
    public void create (String unaPalabra){

        try {
            conn.conectar ("palabras");
            String query="INSERT INTO palabras (palabra) values (?)";
            PreparedStatement pst=conn.crearPst ( query );
            pst.setString ( 1,(String)unaPalabra );
            pst.executeUpdate ();
            conn.cerrarPst ( pst );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
            System.out.println ( "No se pudo ingresar la palabra" );
        }
    }


    /**
     * Metodo getPalabra selecciona una palabra al azar de la base datos y la retorna
     * @return unaPalabra
     */
    public String read() {

        String unaPalabra="";
        try {
            conn.conectar ("palabras");
            String query="SELECT * FROM palabras ORDER BY rand() limit 1";
            Statement st=conn.crearst ();

            ResultSet rs= st.executeQuery ( query );
            if (rs.next()){
                unaPalabra=rs.getString ( "palabra" );
            }
            conn.cerrarRs ( rs );
            conn.cerrarStsement ( st );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return unaPalabra;
    }


    /**
     * Metodo update recibe como parametro la vieja palabra y la nueva y realiza el reemplazo
     * @param oldPalabra
     * @param newPalabra
     */
    public void update(String newPalabra, String oldPalabra ) {
        try {
            conn.conectar ("palabras");
            String query="UPDATE palabras SET palabra=? WHERE palabra=?";
            PreparedStatement pst=conn.crearPst ( query );
            pst.setString ( 1,newPalabra );
            pst.setString ( 2,oldPalabra );
            pst.executeUpdate ();
            conn.cerrarPst ( pst );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
            System.out.println ( "no se pudo modificar la palabra" );
        }
    }

    /**
     * Metodo delete elimina la palabra recibida por parametro de la base de datos
     * @param palabra
     */
    public void delete(String palabra) {
        try {
            conn.conectar ("palabras");
            String query="DELETE FORM palabras WHERE palabra=?)";
            PreparedStatement pst=conn.crearPst ( query );
            pst.setString ( 1,palabra );
            pst.executeUpdate ();
            conn.cerrarPst ( pst );
            conn.cerrarConexion ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
