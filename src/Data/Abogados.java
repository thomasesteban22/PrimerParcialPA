package Data;

import Conexion.ConexionMySQL;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Abogados {
    private int id;
    private String nombre;

    private String apellido;
    private int cedula;
    private int tarjetaProfesional;

    public Abogados(int id, String nombre, String apellido, int cedula, int celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tarjetaProfesional = celular;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    }

    public static int generarIdAbogado() throws SQLException, ClassNotFoundException {
            String url = "jdbc:mysql://localhost:3306/magnaabogados";
            String usuario = "root";
            String contraseña = "";

            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
                Statement declaracion = conexion.createStatement();
                ResultSet resultado = declaracion.executeQuery("SELECT MAX(id) FROM abogados");

                if (resultado.next()) {
                    int ultimoId = resultado.getInt(1);
                    System.out.println("El último valor de la columna 'id' es: " + ultimoId);
                    return ultimoId + 1;
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener el último valor de la columna 'id': " + e.getMessage());
            }
            return 0;
        }


    // Método para guardar el cliente en la base de datos
    public void guardarEnBaseDeDatos() {
        // Creamos una instancia de ConexionMySQL
        ConexionMySQL conexion = new ConexionMySQL();

        // Llamamos al método guardarCliente con los datos del cliente
        conexion.guardarAbogado(id, nombre, apellido, cedula, tarjetaProfesional);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}

