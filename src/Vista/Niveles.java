package Vista;


import Modelo.*;
import control.Control;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Casa
 */
public class Niveles extends JFrame implements ActionListener{

    private Control control;


    public Niveles(Control control) {
        super("Niveles");
        this.control = control;
    }

    public void init(ArrayList<String> colum) {
        JPanel panel = new JPanel(), jPanel1 = new JPanel(), jPanel2 = new JPanel();
        JTable tabla = new JTable();
        Tabla table = new Tabla("Nombre columna");
        tabla.setModel(table);
        
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                  
                }
            }
        });
        JScrollPane desplazamientoTabla = new JScrollPane();
        desplazamientoTabla.setViewportView(tabla);
        for (int i = 0; i < colum.size(); i++) {
            table.addRow(
                    new Object[]{
                        colum.get(i)});
        }
        JButton volver = new JButton("Volver");
        volver.addActionListener(this);
        panel.setLayout(new BorderLayout());
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(desplazamientoTabla, BorderLayout.CENTER);
        jPanel2.add(volver);
        panel.add(jPanel1, BorderLayout.CENTER);
        panel.add(jPanel2, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       control.atras("columnas");
    }

    public void init(String colum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
