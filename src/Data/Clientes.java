package Data;
import Conexion.ConexionClientesMySQL;

public class Clientes {
    private String nombre;
    private String apellido;
    private int cedula;
    private int celular;

    // Constructor de la clase
    public Clientes(String nombre, String apellido, int cedula, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
    }

    // Método para guardar el cliente en la base de datos
    public void guardarEnBaseDeDatos() {
        // Creamos una instancia de ConexionMySQL
        ConexionClientesMySQL conexion = new ConexionClientesMySQL();

        // Llamamos al método guardarCliente con los datos del cliente
        conexion.guardarCliente(nombre, apellido, cedula, celular);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}
