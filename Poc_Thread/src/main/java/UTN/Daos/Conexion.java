package UTN.Daos;

import java.sql.*;

public class Conexion {

    private Connection conn;

    /**
     * Contructor de la clase conexion que no necesita parametros de entrada
     */
    public Conexion() {
        conn = null;
    }

    /**
     * Metodo conetcar que permite establecer una conexion con una base de datos
     */
    public void conectar(String nombreBD){
        String jdbc="jdbc:mysql://localhost/"+nombreBD+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            conn=DriverManager.getConnection(jdbc,"root","");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo conectar con la base de datos");
        }
    }

    /**
     * Metodo cerrar conexion que cierra la conexion a la base de datos
     */
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

    /**
     * Metodo cerrarStatement que cierra una Statement enviado por parametro
     * @param st
     */
    public void cerrarStsement(Statement st){
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo cerrar el statement");
        }
    }

    /**
     * Metodo cerrarPst que cierra un PreparedStatement enviado por parametro
     * @param pst
     */
    public void cerrarPst(PreparedStatement pst){
        try {
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("No se pudo cerrar el PrepareStatement");
        }
    }

    /**
     * Metodo crearst que crea un objeto Statement y lo retorna
     * @return
     */
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

    /**
     * Metodo crearPst crea un objeto PreoareStatement y lo retorna
     * @param query
     * @return
     */
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

    /**
     * Metodo cerrarRs cierra un ResultSet abierto que necesita ser enviado por parametro
     * @param rs
     */
    public void cerrarRs (ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no se pudo cerrar el resultset");
        }
    }

}
