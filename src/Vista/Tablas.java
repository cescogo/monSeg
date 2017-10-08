package Vista;

import Modelo.Render;
import Modelo.Tabla;
import control.Control;
import java.awt.BorderLayout;
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
import modelo.*;

/**
 *
 * @author cesar
 */
public class Tablas extends JFrame implements ActionListener {

    private Control control;

    public Tablas(Control control) {
        super("tablas");
        this.control = control;
    }

    public void init(ArrayList<Table> TaSpa) {
        JPanel panel = new JPanel(), jPanel1 = new JPanel(), jPanel2 = new JPanel();
        JTable tabla = new JTable();
        Tabla table = new Tabla("Nombre tablas","Accesible");
        JButton volver = new JButton("Volver");
        tabla.setModel(table);
        tabla.setDefaultRenderer(Object.class, new Render());
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = tabla.getSelectedRow();
                    int colum = tabla.getSelectedColumn();
                    System.out.println(tabla.getValueAt(row, colum).toString());
                }
            }
        });
        JScrollPane desplazamientoTabla = new JScrollPane();
        desplazamientoTabla.setViewportView(tabla);
        for (int i = 0; i < TaSpa.size(); i++) {
            table.addRow(
                    new Object[]{
                        TaSpa.get(i).getName(),false
                    });
        }
        volver.addActionListener(this);
        panel.setLayout(new BorderLayout());
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(desplazamientoTabla, BorderLayout.CENTER);
        jPanel2.add(volver);
        panel.add(jPanel1, BorderLayout.CENTER);
        panel.add(jPanel2,BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Volver")) {
            control.atras("Tablas");
        }
    }
}
