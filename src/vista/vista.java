package vista;

import javax.swing.*;

public class vista extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton AGREGARButton;
    private JButton BUSCARButton;
    private JButton LIMPIARButton;
    private JPanel panel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    };

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }
    public vista(){
        setContentPane(panel);
        setTitle("Vista persona");
        setSize(450, 450);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }



}
