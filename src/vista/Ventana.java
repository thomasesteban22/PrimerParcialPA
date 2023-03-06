package vista;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
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
        JButton guardarAbogado = new JButton("Guardar");
        guardarAbogado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreAbogado.getText();
                String apellido = apellidoAbogado.getText();
                int cedula = Integer.parseInt(cedulaAbogado.getText());
                int tarjeta = Integer.parseInt(tarjetaProfesional.getText());
                Abogados abogados = null;
                try {
                    int  id = abogados.generarIdAbogado();
                    abogados = new Abogados(id, nombre, apellido, cedula, tarjeta);
                    abogados.guardarEnBaseDeDatos();
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
        pestañas.addTab("Registrar Abogado", panelAbogado);

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
        JButton guardarCliente = new JButton("Guardar");
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
                    cliente = new Clientes(id, nombre,apellido, cedula, celular );
                    cliente.guardarEnBaseDeDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Cliente guardado: " + nombre + " " + apellido + " - " + cedula + " - " + celular);
            }
        });
        panelCliente.add(guardarCliente);


        pestañas.addTab("Registrar Cliente", panelCliente);
        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new BoxLayout(panelAcciones, BoxLayout.PAGE_AXIS));
        int buscarCliente = new JTextField(20);

        JTextField fechaAcciones = new JTextField(20);
        JTextField comentariosAcciones = new JTextField(20);
        panelAcciones.add(new JLabel("Buscar cliente"));
        panelAcciones.add(buscarCliente);
        JButton guardarBusquedaCliente = new JButton("Buscar");
        panelAcciones.add(guardarBusquedaCliente);
        panelAcciones.add(new JLabel("Fecha:"));
        panelAcciones.add(fechaAcciones);
        panelAcciones.add(new JLabel("Comentarios:"));
        panelAcciones.add(comentariosAcciones);
        JButton guardarAcciones = new JButton("Guardar");
        guardarBusquedaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes cliente = null;
                Clientes busquedaCliente = null;

            }
        });
        guardarAcciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = fechaAcciones.getText();
                String comentarios = comentariosAcciones.getText();
                Acciones accion = new Acciones(1, fecha,comentarios );
                accion.guardarEnBaseDeDatos();
                System.out.println("Acción guardada: " + fecha + " - " + comentarios);
            }
        });
        panelAcciones.add(guardarAcciones);

        // Agregar panel de "Registrar Acciones" a la pestaña
        pestañas.addTab("Registrar Acciones", panelAcciones);

        // Crear panel de "Tipo de Proceso"
        JPanel panelProceso = new JPanel();
        panelProceso.setLayout(new BoxLayout(panelProceso, BoxLayout.PAGE_AXIS));
        JTextField tipoProceso = new JTextField(20);
        panelProceso.add(new JLabel("Tipo de Proceso:"));
        panelProceso.add(tipoProceso);
        JButton guardarProceso = new JButton("Guardar");
        guardarProceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = tipoProceso.getText();
                TipoDeProceso proceso = null;
                int id = 0;
                try {
                    id = proceso.generarIdProceso();
                    proceso = new TipoDeProceso(id, tipo);
                    proceso.guardarEnBaseDeDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


                System.out.println("Proceso guardado: " + id + " - " + tipo);
            }
        });
        panelProceso.add(guardarProceso);

        // Agregar panel de "Tipo de Proceso" a la pestaña
        pestañas.addTab("Tipo de Proceso", panelProceso);

        // Agregar pestañas al JFrame
        add(pestañas);

        // Configuración del JFrame
        setTitle("Registro de Abogados y Clientes");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        //buscarAbogado();
        Ventana ventana = new Ventana();

    }


}

