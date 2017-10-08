package Vista;

import control.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Casa
 */
public class Roles extends JFrame implements ActionListener {

    private Control control;

    public Roles(Control control) {
        super("Roles");
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
