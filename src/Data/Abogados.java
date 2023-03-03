package Data;

import Conexion.ConexionAbogadosMySQL;
import Conexion.ConexionClientesMySQL;

public class Abogados {
    private String nombre;
    private String apellido;
    private int cedula;
    private int tarjetaProfesional;
    public Abogados(String nombre, String apellido, int cedula, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tarjetaProfesional = celular;
    }

    // Método para guardar el cliente en la base de datos
    public void guardarEnBaseDeDatos() {
        // Creamos una instancia de ConexionMySQL
        ConexionAbogadosMySQL conexion = new ConexionAbogadosMySQL();

        // Llamamos al método guardarCliente con los datos del cliente
        conexion.guardarAbogado(nombre, apellido, cedula, tarjetaProfesional);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}

