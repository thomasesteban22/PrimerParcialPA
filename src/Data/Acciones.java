package Data;

import Conexion.ConexionMySQL;

public class Acciones {
    private int id;
    private String fechaDeLaAccion;
    private String comentarios;

    public Acciones(int id, String fechaDeLaAccion, String comentarios) {
        this.id = id;
        this.fechaDeLaAccion = fechaDeLaAccion;
        this.comentarios = comentarios;
    }
    public void guardarEnBaseDeDatos() {
        // Creamos una instancia de ConexionMySQL
        ConexionMySQL conexion = new ConexionMySQL();

        // Llamamos al método guardarCliente con los datos del cliente
        conexion.guardarAccion(id, fechaDeLaAccion, comentarios);

        // Cerramos la conexión a la base de datos
        conexion.cerrarConexion();
    }
}


