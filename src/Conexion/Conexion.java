package Conexion;


import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Conexion {
    private final String url = "jdbc:mysql://localhost:3306/ventas";
    private final String user = "root";
    private final String pwd="";

    public Conexion()
    {}

    public ResultSet Listar(String Cad) {//Dar acceso al servidor de mysql
        try
        {
            Connection cn= DriverManager.getConnection(url,user,pwd);// un objeto conexion se conecta con la base de datos
            PreparedStatement da= cn.prepareStatement(Cad);
            ResultSet tbl = da.executeQuery();
            return tbl;
        }
        catch (SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    public String Ejecutar (String cad){
        try
        {
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(cad);
            int r = da.executeUpdate();
            return "Se afectaron " + r + " filas.";
        }
        catch(SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return "Error "+e.getMessage();
        }
    }
}

