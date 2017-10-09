package Vista;


import Modelo.*;
import control.Control;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Casa
 */
public class Niveles extends JFrame implements ActionListener,ItemListener{

    private Control control;
    private JCheckBox[] nivel;


    public Niveles(Control control) {
        super("Niveles");
        this.control = control;
    }

    public void init(ArrayList<String> colum) {
        JPanel panel = new JPanel(), jPanel1 = new JPanel(), jPanel2 = new JPanel(), jPanel3 = new JPanel();
        JPanel[] rowpanel = new JPanel[5];
        JTable tabla = new JTable();
         nivel = new JCheckBox[5];
        Tabla table = new Tabla("Nombre columna");
        tabla.setModel(table);
        jPanel3.setVisible(false);
        
        jPanel3.setLayout(new GridLayout(5,1));
        for(int i = 0; i < 5; i++) 
            {
            rowpanel[i] = new JPanel();
           JCheckBox box =new JCheckBox("Nivel "+(i+1));
            box.addItemListener((ItemListener) this);
            nivel[i] = box;
            rowpanel[i].add(nivel[i]);
            jPanel3.add(rowpanel[i]);      
            }
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                  jPanel3.setVisible(true);
//                  nivel[0].setSelected(true);
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
        JButton volver = new JButton("Volver"),guardar = new JButton("Guardar");
        guardar.addActionListener(this);
        volver.addActionListener(this);
        panel.setLayout(new BorderLayout());
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(desplazamientoTabla, BorderLayout.CENTER);
        jPanel2.add(volver);
        jPanel2.add(guardar);
        
        
 
     
        
        panel.add(jPanel1, BorderLayout.WEST);
        panel.add(jPanel3, BorderLayout.EAST);
        panel.add(jPanel2, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Guardar"))
        {
            for(int i=0;i<nivel.length;i++)
           if(nivel[i].isSelected())
           {
               System.out.println(nivel[i].getActionCommand());
           }
        }
        else{
       control.atras("columnas");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

  

}
