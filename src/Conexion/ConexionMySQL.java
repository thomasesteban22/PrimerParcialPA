package Conexion;

import java.sql.*;



public class ConexionMySQL {
    private static final String HOST = "localhost";
    private static final String PUERTO = "3306";
    private static final String BD = "magnaabogados";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection conexion;
    private java.sql.PreparedStatement PreparedStatement;

    public ConexionMySQL() {
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
    public void guardarAccion(int id, String fechaDeLaAccion, String comentarios) {
        String sql = "INSERT INTO acciones (id, fechaDeLaAccion, comentarios) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, fechaDeLaAccion);
            pstmt.setString(3, comentarios);
            pstmt.executeUpdate();
            System.out.println("Accion guardada en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar la accion en la base de datos: " + e.getMessage());
        }
    }
    public void guardarTipoDeProceso(int id, String tipo) {
        String sql = "INSERT INTO tipoDeProceso (id, tipo) VALUES (?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, tipo);
            pstmt.executeUpdate();
            System.out.println("Tipo de proceso guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar tipo de proceso la base de datos: " + e.getMessage());
        }
    }
    public void guardarCliente(int id, String nombre, String apellido, int cedula, int celular) {
        String sql = "INSERT INTO clientes (id, nombre, apellido, cedula, celular) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, cedula);
            pstmt.setInt(5, celular);
            pstmt.executeUpdate();
            System.out.println("Cliente guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente en la base de datos: " + e.getMessage());
        }
    }
    public void guardarAbogado(int id, String nombre, String apellido, int cedula, int tarjetaProfesional) {
        String sql = "INSERT INTO abogados (id, nombre, apellido, cedula, tarjetaProfesional) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, cedula);
            pstmt.setInt(5, tarjetaProfesional);
            pstmt.executeUpdate();
            System.out.println("Abogado guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el abogado en la base de datos: " + e.getMessage());
        }
    }


    public PreparedStatement prepareStatement(String consulta) {
        return PreparedStatement;
    }
}
