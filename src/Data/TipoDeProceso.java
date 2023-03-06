package Data;

import Conexion.ConexionMySQL;

import java.sql.*;

public class TipoDeProceso {
    private int id;
    private String tipo;

    public TipoDeProceso(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    public static int generarIdProceso() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/magnaabogados";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT MAX(id) FROM tipoDeProceso");

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
        conexion.guardarTipoDeProceso(id, tipo);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}
