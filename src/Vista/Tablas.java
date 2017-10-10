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
import java.util.HashMap;
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
    private JTable tabla;
    private HashMap<String, Boolean> acciones;

    public Tablas(Control control) {
        super("tablas");
        this.control = control;
        tabla = new JTable();
        acciones = new HashMap<>();
    }

    public void init(ArrayList<Table> TaSpa) {
        HashMap<String, String> map;
        Boolean aux;
        JPanel panel = new JPanel(), jPanel1 = new JPanel(), jPanel2 = new JPanel(), jPanel3 = new JPanel();
        Tabla table = new Tabla("Nombre tablas");
        JButton volver = new JButton("Volver");
        tabla.setModel(table);
        tabla.setDefaultRenderer(Object.class, new Render());
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    String tab;
//                    String val;
//                    Boolean valor = false;
                    int row = tabla.getSelectedRow();
                    int colum = tabla.getSelectedColumn();
                      tab = tabla.getValueAt(row, 0).toString();
                      control.iniciarNiveles(tab);
                        
//                        val = tabla.getValueAt(row, 1).toString();
//                        if(val.equals("true"))
//                            valor = true;
//                        if (acciones.get(tab) != null) {
//                            acciones.replace(tab,valor);
//                        } else {
//                            acciones.put(tab, valor);
//                        }
                    
                }
            }
        });
        JScrollPane desplazamientoTabla = new JScrollPane();
        desplazamientoTabla.setViewportView(tabla);
        map = control.obtenerModificacionesNiveles();
        for (int i = 0; i < TaSpa.size(); i++) {
            if (map.get(TaSpa.get(i).getName()) != null) {
                aux = true;
            } else {
                aux = false;
            }
            table.addRow(
                    new Object[]{
                        TaSpa.get(i).getName(), aux
                    });
        }
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
        if (e.getActionCommand().equals("Volver")) {
            control.atras("Tablas");
        }
        if (e.getActionCommand().equals("Guardar")) {
            control.guardarModificacionesNiveles(acciones);
            control.atras("Tablas");
        }
    }
}
