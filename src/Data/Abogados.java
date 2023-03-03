package Data;

import Conexion.ConexionMySQL;

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

