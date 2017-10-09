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
public class Principal extends JFrame implements ActionListener {

    private Control control;

    public Principal(Control control) {
        super("Inicio");
        this.control = control;
    }

    public void init() {
       JPanel panel = new JPanel(),jPanel = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 0, 50);
        JButton niveles = new JButton("Niveles"), roles = new JButton("Roles");
        niveles.addActionListener(this);
        roles.addActionListener(this);
        panel.add(niveles, BorderLayout.CENTER);
        panel.add(roles, BorderLayout.CENTER);
        jPanel.add(panel, BorderLayout.CENTER);
        add(jPanel, BorderLayout.CENTER);
        pack();
        this.setSize(200, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Niveles")) {
            control.iniciarTablespaces(0);
        } else {
            control.iniciarRoles();
        }
    }

}
