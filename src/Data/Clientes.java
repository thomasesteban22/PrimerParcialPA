package Data;
import Conexion.ConexionMySQL;

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

    public void guardarEnBaseDeDatos() {
        // Creamos una instancia de ConexionMySQL
        ConexionMySQL conexion = new ConexionMySQL();

        // Llamamos al método guardarCliente con los datos del cliente
        conexion.guardarCliente(id, nombre, apellido, cedula, celular);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}
