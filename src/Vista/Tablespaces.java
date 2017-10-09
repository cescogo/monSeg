package Vista;

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
import modelo.TableSpace;

/**
 *
 * @author cesar
 */
public class Tablespaces extends JFrame implements ActionListener {

    private Control control;
 

    public Tablespaces(Control control) {
        super("Tablespaces");
        this.control = control;
    }

    public void init(ArrayList<TableSpace> TaSpa) {
        JPanel panel = new JPanel(), jPanel1 = new JPanel(), jPanel2 = new JPanel();
        JTable tabla = new JTable();
        Tabla table = new Tabla("Nombre tablespaces");
        tabla.setModel(table);
        
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabla.getSelectedRow();
                    int colum = tabla.getSelectedColumn();
                    control.iniciarTablas(tabla.getValueAt(row, colum).toString());
                }
            }
        });
        JScrollPane desplazamientoTabla = new JScrollPane();
        desplazamientoTabla.setViewportView(tabla);
        for (int i = 0; i < TaSpa.size(); i++) {
            table.addRow(
                    new Object[]{
                        TaSpa.get(i).getNombre()});
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
        control.atras("Tablespaces");
    }
}
