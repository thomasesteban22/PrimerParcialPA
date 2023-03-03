package Conexion;

import java.sql.*;



public class ConexionClientesMySQL {
    private static final String HOST = "localhost";
    private static final String PUERTO = "3306";
    private static final String BD = "magnaabogados";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection conexion;
    private java.sql.PreparedStatement PreparedStatement;

    public ConexionClientesMySQL() {
        try {
            String url = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + BD;
            conexion = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Conexión a la base de datos cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
    public void guardarCliente(String nombre, String apellido, int cedula, int celular) {
        String sql = "INSERT INTO clientes (nombre, apellido, cedula, celular) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, cedula);
            pstmt.setInt(4, celular);
            pstmt.executeUpdate();
            System.out.println("Cliente guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente en la base de datos: " + e.getMessage());
        }
    }
    public void guardarAbogado(String nombre, String apellido, int cedula, int tarjetaProfesional) {
        String sql = "INSERT INTO clientes (nombre, apellido, cedula, tarjetaProfesional) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, cedula);
            pstmt.setInt(4, tarjetaProfesional);
            pstmt.executeUpdate();
            System.out.println("Abogado guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente en la base de datos: " + e.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        return PreparedStatement;
    }
}
