package Modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class Tabla extends DefaultTableModel {

    private boolean[] editable = {false, true};

    public Tabla(String nombre) {
        super(new Object[][]{},
                new Object[]{
                    nombre});
    }

    public Tabla(String nombre, String columna) {
        super(new String[]{nombre, columna}, 0);

    }
    Class[] types = new Class[]{
        java.lang.Object.class, java.lang.Boolean.class
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable[column];
    }
}
