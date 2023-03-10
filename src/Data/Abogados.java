package Data;

import Conexion.ConexionMySQL;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Abogados {
    public int id;
    public String nombre;

    public String apellido;
    public int cedula;
    public int tarjetaProfesional;

    public Abogados(int id, String nombre, String apellido, int cedula, int celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tarjetaProfesional = celular;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    }
    public static Abogados buscarAbogado(int cedulaB) {
        String url = "jdbc:mysql://localhost:3306/magnaabogados";
        String usuario = "root";
        String contraseña = "";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String consulta = "SELECT * FROM abogados WHERE cedula = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, cedulaB);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                int id = resultado.getInt("id");
                System.out.println(id);
                String nombre = resultado.getString("nombre");
                System.out.println(nombre);
                String apellido = resultado.getString("apellido");
                System.out.println(apellido);
                int cedula = resultado.getInt("cedula");
                System.out.println(cedula);
                int tarjetaProfesional = resultado.getInt("tarjetaProfesional");
                System.out.println(tarjetaProfesional);

                return new Abogados(id, nombre, apellido, cedula, tarjetaProfesional);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
    /*public static void editarAbogado(){
        try {
            Abogados abogado = null;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "tu_usuario", "tu_contraseña");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Abogados SET nombre='" + nombre + "', apellido='" + apellido + "', cedula='" + cedula + "', tarjeta_profesional='" + tarjetaProf + "' WHERE id=" + abogado.getId();
            stmt.executeUpdate(sql);

            abogado.buscarAbogado(1);



            JOptionPane.showMessageDialog(this, "Los datos del abogado han sido actualizados.");
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al actualizar los datos del abogado.");
            ex.printStackTrace();
        }
    }
    }*/

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

