package vista;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import Conexion.ConexionMySQL;
import Data.*;
public class Ventana extends JFrame {


    private JTabbedPane pestañas;


    public Ventana() {
        // Crear pestañas
        pestañas = new JTabbedPane();

        JPanel panelAbogado = new JPanel();
        panelAbogado.setLayout(new BoxLayout(panelAbogado, BoxLayout.PAGE_AXIS));
        JTextField nombreAbogado = new JTextField(20);
        JTextField apellidoAbogado = new JTextField(20);
        JTextField cedulaAbogado = new JTextField(20);
        JTextField tarjetaProfesional = new JTextField(20);
        panelAbogado.add(new JLabel("Nombre:"));
        panelAbogado.add(nombreAbogado);
        panelAbogado.add(new JLabel("Apellido:"));
        panelAbogado.add(apellidoAbogado);
        panelAbogado.add(new JLabel("Cedula:"));
        panelAbogado.add(cedulaAbogado);
        panelAbogado.add(new JLabel("Tarjeta Profesional:"));
        panelAbogado.add(tarjetaProfesional);
        JButton guardarAbogado = new JButton("Guardar nuevo");
        JButton buscarAbogado = new JButton("Buscar por cedula");
        JButton limpiarA = new JButton("Limpiar");
        JButton editarA = new JButton("Editar y guardar");
        JFrame frame = new JFrame("Mensaje de éxito");


        editarA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = nombreAbogado.getText();
                String apellido = apellidoAbogado.getText();
                String cedula = cedulaAbogado.getText();
                String tarjetaProfesionalb = tarjetaProfesional.getText();
                Abogados abogado = Abogados.buscarAbogado(Integer.parseInt(cedula));
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magnaabogados", "root", "");
                    Statement stmt = conn.createStatement();
                    String sql = "UPDATE abogados SET nombre='" + nombre + "', apellido='" + apellido + "', cedula='" + cedula + "', tarjetaProfesional='" + tarjetaProfesionalb + "' WHERE cedula=" + abogado.cedula;
                    ;
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(frame, "Abogado: " + nombre + " editado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        limpiarA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreAbogado.setText("");
                apellidoAbogado.setText("");
                cedulaAbogado.setText("");
                tarjetaProfesional.setText("");
            }
        });
        panelAbogado.add(editarA);
        panelAbogado.add(limpiarA);
        buscarAbogado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Abogados abogado = null;
                Abogados guardarObjAbogado = null;
                String cedulaB1 = cedulaAbogado.getText();
                int cedulaB = Integer.parseInt(cedulaB1);
                guardarObjAbogado = abogado.buscarAbogado(cedulaB);
                nombreAbogado.setText(guardarObjAbogado.nombre);
                apellidoAbogado.setText(guardarObjAbogado.apellido);
                cedulaAbogado.setText(String.valueOf(guardarObjAbogado.cedula));
                tarjetaProfesional.setText(String.valueOf(guardarObjAbogado.tarjetaProfesional));
                Abogados finalGuardarObjCliente = guardarObjAbogado;
                System.out.println(finalGuardarObjCliente);
            }
        });
        panelAbogado.add(buscarAbogado);
        guardarAbogado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreAbogado.getText();
                String apellido = apellidoAbogado.getText();
                int cedula = Integer.parseInt(cedulaAbogado.getText());
                int tarjeta = Integer.parseInt(tarjetaProfesional.getText());
                Abogados abogados = null;
                try {
                    int id = abogados.generarIdAbogado();
                    abogados = new Abogados(id, nombre, apellido, cedula, tarjeta);
                    abogados.guardarEnBaseDeDatos();
                    JOptionPane.showMessageDialog(frame, "Abogado: " + nombre + " guardado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Abogado guardado: " + nombre + " " + apellido + " - " + cedula + " - " + tarjeta);
            }
        });
        panelAbogado.add(guardarAbogado);

        // Agregar panel de "Registrar Abogado" a la pestaña
        pestañas.addTab("Abogado", panelAbogado);

        // Crear panel de "Registrar Cliente"
        JPanel panelCliente = new JPanel();
        panelCliente.setLayout(new BoxLayout(panelCliente, BoxLayout.PAGE_AXIS));
        JTextField nombreCliente = new JTextField(20);
        JTextField apellidoCliente = new JTextField(20);
        JTextField cedulaCliente = new JTextField(20);
        JTextField celularCliente = new JTextField(20);
        panelCliente.add(new JLabel("Nombre:"));
        panelCliente.add(nombreCliente);
        panelCliente.add(new JLabel("Apellido:"));
        panelCliente.add(apellidoCliente);
        panelCliente.add(new JLabel("Cedula:"));
        panelCliente.add(cedulaCliente);
        panelCliente.add(new JLabel("Celular:"));
        panelCliente.add(celularCliente);
        panelCliente.add(new JLabel(""));
        JButton guardarCliente = new JButton("Guardar nuevo");
        JButton buscarCliente = new JButton("Buscar por cedula");
        JButton limpiarC = new JButton("Limpiar");
        JButton editarC = new JButton("Editar y guardar");
        editarC.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String nombre = nombreCliente.getText();
                String apellido = apellidoCliente.getText();
                String cedula = cedulaCliente.getText();
                String celular = celularCliente.getText();
                Clientes cliente = Clientes.buscarCliente(Integer.parseInt(cedula));
                ConexionMySQL conexion = new ConexionMySQL();
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magnaabogados", "root", "");
                    Statement stmt = conn.createStatement();
                    String sql = "UPDATE clientes SET nombre='" + nombre + "', apellido='" + apellido + "', cedula='" + cedula + "', celular='" + celular + "' WHERE cedula=" + cliente.cedula;
                    ;
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(frame, "Cliente: " + nombre + " editado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panelCliente.add(editarC);

        limpiarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreCliente.setText("");
                apellidoCliente.setText("");
                cedulaCliente.setText("");
                celularCliente.setText("");
            }
        });
        panelCliente.add(limpiarC);
        buscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes cliente = null;
                Clientes guardarObjCliente = null;
                String cedulaB1 = cedulaCliente.getText();
                int cedulaB = Integer.parseInt(cedulaB1);
                guardarObjCliente = cliente.buscarCliente(cedulaB);
                nombreCliente.setText(guardarObjCliente.nombre);
                apellidoCliente.setText(guardarObjCliente.apellido);
                cedulaCliente.setText(String.valueOf(guardarObjCliente.cedula));
                celularCliente.setText(String.valueOf(guardarObjCliente.celular));
                Clientes finalGuardarObjCliente = guardarObjCliente;
                System.out.println(finalGuardarObjCliente);
            }
        });
        panelCliente.add(buscarCliente);
        guardarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreCliente.getText();
                String apellido = apellidoCliente.getText();
                int cedula = Integer.parseInt(cedulaCliente.getText());
                int celular = Integer.parseInt(celularCliente.getText());
                Clientes cliente = null;
                try {
                    int id = cliente.generarIdCliente();
                    cliente = new Clientes(id, nombre, apellido, cedula, celular);
                    cliente.guardarEnBaseDeDatos();
                    JOptionPane.showMessageDialog(frame, "Cliente: " + nombre + " guardado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Cliente guardado: " + nombre + " " + apellido + " - " + cedula + " - " + celular);
            }
        });
        panelCliente.add(guardarCliente);


        pestañas.addTab("Cliente", panelCliente);
        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new BoxLayout(panelAcciones, BoxLayout.PAGE_AXIS));
        JTextField campoBuscarCliente = new JTextField(20);
        JTextField fechaAcciones = new JTextField(20);
        JTextField comentariosAcciones = new JTextField(20);
        panelAcciones.add(new JLabel("Buscar cliente por cedula"));
        panelAcciones.add(campoBuscarCliente);
        JLabel nombreBusquedaCliente = new JLabel("CLIENTE");
        panelAcciones.add(nombreBusquedaCliente);
        JButton guardarBusquedaCliente = new JButton("Buscar");
        panelAcciones.add(guardarBusquedaCliente);
        panelAcciones.add(new JLabel("Guardar acción:"));
        panelAcciones.add(comentariosAcciones);
        JButton guardarAcciones = new JButton("Guardar");
        guardarAcciones.setEnabled(false);
        guardarBusquedaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes cliente = null;
                Clientes guardarObjClienteA = null;
                String cedulaB1 = campoBuscarCliente.getText();
                int cedulaB = Integer.parseInt(cedulaB1);
                guardarObjClienteA = cliente.buscarCliente(cedulaB);
                nombreBusquedaCliente.setText("-------" + guardarObjClienteA.nombre + " " + guardarObjClienteA.apellido + "-------");

                Clientes finalGuardarObjClienteA = guardarObjClienteA;
                System.out.println(finalGuardarObjClienteA);
                guardarAcciones.setEnabled(true);
                guardarAcciones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LocalDate fechaLocal = LocalDate.now();
                        String fecha = fechaLocal.toString();
                        String comentarios = comentariosAcciones.getText();
                        Acciones accion = new Acciones(finalGuardarObjClienteA.id, fecha, comentarios);
                        System.out.println(finalGuardarObjClienteA);
                        accion.guardarEnBaseDeDatos();
                        System.out.println(finalGuardarObjClienteA);
                        System.out.println("Acción guardada: " + fecha + " - " + comentarios);
                        JOptionPane.showMessageDialog(frame,  "Accion guardada con exito", "", JOptionPane.INFORMATION_MESSAGE);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }
                });
                panelAcciones.add(guardarAcciones);
            }
        });
        JPanel panelResumen = new JPanel();
        panelResumen.setLayout(new BoxLayout(panelResumen, BoxLayout.PAGE_AXIS));
        panelResumen.add(new JLabel("Cedula del cliente"));
        JTextField cedulaClienteR = new JTextField(20);
        panelResumen.add(cedulaClienteR);
        JButton buscarClienteR = new JButton("Buscar cliente");

        buscarClienteR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/magnaabogados";
                String user = "root";
                String password = "";

                Clientes clientes  = null;
                Clientes clientesR = null;
                String cedulaR = cedulaClienteR.getText();
                int cedualaRI = Integer.parseInt(cedulaR);
                DefaultTableModel model = new DefaultTableModel(new String[]{"fechaDeLaAccion", "comentarios"}, 0);
                clientesR = clientes.buscarCliente(cedualaRI);

                System.out.println(clientesR.nombre);

                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement stmt = conn.prepareStatement("SELECT fechaDeLaAccion, comentarios FROM acciones WHERE id = ?")) {
                    stmt.setInt(1, clientesR.id);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        String fecha = rs.getString("fechaDeLaAccion");
                        String acciones = rs.getString("comentarios");
                        model.addRow(new Object[]{fecha, acciones});
                    }

                } catch (SQLException f) {
                    f.printStackTrace();
                }

                // Crear la tabla JTable y agregar el modelo de tabla personalizado
                JTable table = new JTable(model);

                // Crear el JScrollPane y agregar la tabla JTable
                JScrollPane scrollPane = new JScrollPane(table);

                // Agregar el JScrollPane al JFrame
                panelResumen.add(scrollPane);
            }
        });
        panelResumen.add(buscarClienteR);


        pestañas.addTab("Registrar Acciones", panelAcciones);
        pestañas.addTab("Ver resumen cliente", panelResumen);


        // Agregar panel de "Registrar Acciones" a la pestaña


        // Agregar pestañas al JFrame
        add(pestañas);

        // Configuración del JFrame
        setTitle("Registro de Abogados y Clientes");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void asd(int id) {


    }




    public static void main(String[] args) {
        //buscarAbogado();
        Ventana ventana = new Ventana();

    }


}

