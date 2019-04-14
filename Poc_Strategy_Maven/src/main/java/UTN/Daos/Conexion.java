package UTN.Daos;

import java.sql.*;

public class Conexion {

    private Connection conn;

    public Conexion() {
        conn = null;
    }

    public void conectar(){
        String jdbc="jdbc:mysql://localhost/ganadoresstrategy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            conn=DriverManager.getConnection(jdbc,"root","");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo conectar con la base de datos");
        }
    }

    public void cerrarConexion() {
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("No se puede cerrar la base de datos");
            }
        }
    }

    public void cerrarStsement(Statement st){
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo cerrar el statement");
        }
    }

    public void cerrarPst(PreparedStatement pst){
        try {
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo cerrar el PrepareStatement");
        }
    }

    public Statement crearst (){
        Statement st= null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo crear el objeto de tipo statement");
        }
        return (st);
    }

    public PreparedStatement crearPst (String query){
        PreparedStatement pst= null;
        try {
            pst = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo crear el objeto de tipo preparedstatement");
        }
        return (pst);
    }

    public void cerrarRs (ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no se pudo cerrar el resultset");
        }
    }

}
