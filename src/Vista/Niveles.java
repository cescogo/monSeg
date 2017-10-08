package Vista;

import control.Control;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

    public void init() {
        JPanel panel = new JPanel(),jPanel = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 0, 50);
        JButton volver = new JButton("Volver"),
                nivel1 = new JButton("Nivel 1"),
                nivel2 = new JButton("Nivel 2"),
                nivel3 = new JButton("Nivel 3"),
                nivel4 = new JButton("Nivel 4"),
                nivel5 = new JButton("Nivel 5");
        volver.addActionListener(this);
        nivel1.addActionListener(this);
        nivel2.addActionListener(this);
        nivel3.addActionListener(this);
        nivel4.addActionListener(this);
        nivel5.addActionListener(this);
        panel.add(volver, BorderLayout.CENTER);
        panel.add(nivel1, BorderLayout.CENTER);
        panel.add(nivel2, BorderLayout.CENTER);
        panel.add(nivel3, BorderLayout.CENTER);
        panel.add(nivel4, BorderLayout.CENTER);
        panel.add(nivel5, BorderLayout.CENTER);
        jPanel.add(panel, BorderLayout.CENTER);
        add(jPanel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Volver")) {
            control.atras("Niveles");
        } else if (e.getActionCommand().equals("Nivel 1")) {
            control.iniciarTablespaces(1);
        } else if (e.getActionCommand().equals("Nivel 2")) {
            control.iniciarTablespaces(2);
        } else if (e.getActionCommand().equals("Nivel 3")) {
            control.iniciarTablespaces(3);
        } else if (e.getActionCommand().equals("Nivel 4")) {
            control.iniciarTablespaces(4);
        } else {
            control.iniciarTablespaces(5);
        }
    }

}
