package Modelo;

/**
 *
 * @author adan-
 */
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JTable;

public class SQLiteJDBC {

    static Connection c = null;
    static String dir = "org.sqlite.JDBC";
    static String db = "test.db";
    static Statement stmt = null;

    public void conectar() {
        try {
            Class.forName(dir);
            c = DriverManager.getConnection("jdbc:sqlite:" + db);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Conexion Correcta");
    }

    public void query(String sql) throws SQLException {
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Ejecutada");
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertarElementosNivel(int nivel, HashMap<String, Boolean> acciones) {
        Set set = acciones.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if ((Boolean)mentry.getValue()) {
                try {
                    query("INSERT INTO nivel (nivel,tabla)VALUES (" + nivel + ",'" + mentry.getKey() + "');");
                } catch (Exception e) {
                    System.out.print(e);
                }
            } else {
                try {
                    query("DELETE FROM nivel WHERE tabla = '" + mentry.getKey() + "';");
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }/*
        if (acciones.) {
            try {
            } catch (Exception e) {
            }
        } else {

        }*/
    }

    public HashMap<String, String> obtenerElementosNivelPorNivel(int nivel) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select * from nivel where nivel=" + nivel + ";");
        while (rs.next()) {
            rs.getMetaData();
            map.put(rs.getString("tabla"), rs.getString("tabla"));
        }
        rs.close();
        stmt.close();
        return map;
    }
}
