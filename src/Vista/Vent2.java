/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import control.Control;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author cesar
 */
public class Vent2 extends JFrame implements ActionListener{
     
    private JPanel panel;
     private Button aceptar;
    private Control gestor;
   JTable tabla;
   private  ModeloTabla3 table;
  

    public Vent2(Control c) {
        
        super("tablas");
        gestor=c;
        panel= new JPanel();   
        tabla=new JTable();
        table= new ModeloTabla3();
    }

  
    
  public void init(ArrayList<Table> TaSpa)
    {
        tabla.setModel(table);
        tabla.addMouseListener(new MouseAdapter() 
        {
            
            
            public void mouseClicked(MouseEvent e)
            {
                if(e.getClickCount()==1)
                {
                   int row= tabla.getSelectedRow();
                    int colum=tabla.getSelectedColumn();
                    System.out.println(tabla.getValueAt(2, 1).toString());
                  if(colum ==0)
                {
                  // abrir panel de oppciones
                      
                }
                }
                  
                
                
            }
        });
        JScrollPane desplazamientoTabla = new JScrollPane(
                  ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamientoTabla.setViewportView(tabla);
          this.gestor=gestor;
       
        
        Object[][] data = new Object[TaSpa.size()+1][];
        for (int i = 0; i < TaSpa.size(); i++) {
            
            table.addRow(
                     new Object[]{                      
                        TaSpa.get(i).getName()
                        
                    });
            
        }
           
         
       panel.add(BorderLayout.CENTER,desplazamientoTabla);

       
        
        
       
        
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets=new Insets(10,10,0,50);
        JPanel p_opc=new JPanel();
        JButton b_config= new JButton("salir");
        b_config.setActionCommand("salir");
        b_config.addActionListener(this);
       p_opc.add(b_config,BorderLayout.CENTER);
        add(p_opc,BorderLayout.SOUTH); 
        add(panel,BorderLayout.CENTER);
       
       setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("salir"))
        {
            try {
                gestor.atras();
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vent2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Vent2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
   
    }
  class ModeloTabla3 extends DefaultTableModel {

        public ModeloTabla3() {
            super(new Object[][]{},
                    new String[]{            
            "Nombre tabla"});
            
            }
        
      
    }
  
}
