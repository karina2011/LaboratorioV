package UTN.Daos;

import UTN.clases.Humano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoGanador {

    private Conexion conn;

    public DaoGanador(Conexion conn) {

            this.conn = conn;
    }

    public void CargarGanador(Humano ganador){

        String query="INSERT INTO ganadores(nombre,edad,peso) VALUES (?,?,?)";

        try {
            PreparedStatement pst=conn.crearPst(query);
            pst.setString (1, ganador.getNombre());
            pst.setInt (2, ganador.getEdad());
            pst.setInt (3,ganador.getPeso());
            pst.executeUpdate();
            conn.cerrarPst(pst);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se puede realizar la consulta");
        }
    }

    public void mostrarGanadores ()  {

        try {
            Statement st=conn.crearst();
            ResultSet rs = st.executeQuery("SELECT * FROM ganadores");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int peso = rs.getInt("peso");
                System.out.println("Nombre " + nombre + " edad: " + edad + "peso: " + peso);
            }
            conn.cerrarRs(rs);
            conn.cerrarStsement(st);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se puede realizar la consulta");
        }
    }

    public void mostrarUltimoGanador ()  {

        try {
            Statement st=conn.crearst();
            ResultSet rs = st.executeQuery("SELECT * FROM ganadores ORDER by id_ganador DESC limit 1");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int peso = rs.getInt("peso");
                System.out.println("Nombre " + nombre + " edad: " + edad + " peso: " + peso);
            }
            conn.cerrarRs(rs);
            conn.cerrarStsement(st);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se puede realizar la consulta");
        }
    }
}
