package Data;

public class Clientes {
    private String nombre;
    private String apellido;
    private int cedula;
    private int celular;
    public void guardarCliente(String nombre, String apellido, int cedula, int celular) {
        String sql = "INSERT INTO clientes (nombre, apellido, cedula, celular) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, cedula);
            pstmt.setInt(4, celular);
            pstmt.executeUpdate();
            System.out.println("Cliente guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente en la base de datos: " + e.getMessage());
        }
    }


}
