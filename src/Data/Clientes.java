package Data;
import Conexion.ConexionMySQL;

import java.sql.*;

public class Clientes {
    private int id;
    private String nombre;
    private String apellido;
    private int cedula;
    private int celular;

    // Constructor de la clase
    public Clientes(int id, String nombre, String apellido, int cedula, int celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
    }

    public static void main(String[] args) {
        buscarCliente(1);
    }

    public static Abogados buscarCliente(int id) {
        String url = "jdbc:mysql://localhost:3306/magnaabogados";
        String usuario = "root";
        String contraseña = "";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String consulta = "SELECT * FROM abogados WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                System.out.println(nombre);
                String apellido = resultado.getString("apellido");
                System.out.println(apellido);
                int cedula = resultado.getInt("cedula");
                System.out.println(cedula);
                int celular = resultado.getInt("celular");
                System.out.println(celular);
                return new Abogados(id, nombre, apellido, cedula, celular);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el último valor de la columna 'id': " + e.getMessage());
        }
        return null;
    }




    public static int generarIdCliente() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/magnaabogados";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT MAX(id) FROM clientes");

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

    public void guardarEnBaseDeDatos() {
        // Creamos una instancia de ConexionMySQL
        ConexionMySQL conexion = new ConexionMySQL();

        // Llamamos al método guardarCliente con los datos del cliente
        conexion.guardarCliente(id, nombre, apellido, cedula, celular);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}
