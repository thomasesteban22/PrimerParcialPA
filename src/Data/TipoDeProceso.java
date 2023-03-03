package Data;

import Conexion.ConexionMySQL;

public class TipoDeProceso {
    private int id;
    private String tipo;

    public TipoDeProceso(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
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
