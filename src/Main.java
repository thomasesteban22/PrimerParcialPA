import vista.vista;

public class Main {
    public static void main(String[] args) {
        ConexionMySQL conexion = new ConexionMySQL();
        conexion.guardarCliente("Juan", "Pérez", 12345678, 3111111111);
        conexion.cerrarConexion();

    }
}