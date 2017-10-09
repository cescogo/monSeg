package modelo;

import control.Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class Conexion {

    //parametros de configuracion de usuario
    //Descargar ojdbc6.jar e incluirlo en la libreria
    private Connection conexion;
    static String url = "jdbc:oracle:thin:@localhost:1521/XE";
    static String user = "system";
    static String password = "root";
    private boolean exito;
    private Control gestor;

    private ArrayList<String> resultados = new ArrayList<>();

    /*Metodos*/
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        Conexion.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Conexion.password = password;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            exito = true;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
            exito = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            exito = false;
        }
    }

    // se obtienen los segmentos de la base de datos
    public ArrayList<TableSpace> getSegmentos() throws InterruptedException {
        ArrayList<TableSpace> vec = new ArrayList<>();
        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("select tablespace_name from dba_tables where tablespace_name is not null AND tablespace_name != 'SYSTEM' group by tablespace_name");
            while (rs.next()) {
                //Aqui deberia jalar el nombre de la columna
                vec.add(new TableSpace(rs.getString("TABLESPACE_NAME"), 0, 0));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vec;
    }

    // se obtienen las tablas de cada tablespace
    // se obtienen las tablas de la base de datos
    // meter aqui el query de contar los indices de una tabla
    public ArrayList<Table> getTable(String tablespace) throws SQLException {
        ArrayList<Table> vec = new ArrayList<>();
        Statement stm;
        ResultSet rs;
        String a, b;
        stm = conexion.createStatement();
        rs = stm.executeQuery("select TABLE_NAME,OWNER from all_tables where tablespace_name = '" + tablespace + "'");
        //getColumnNames(rs);
        while (rs.next()) {
            a = rs.getString("TABLE_NAME");
            b = rs.getString("OWNER");
            vec.add(new Table(a, b));
        }
        return vec;
    }
    
    public  ArrayList<String> getColonmas(String table) throws SQLException {
        ArrayList<String> vec = new ArrayList<>();
        Statement stm;
        ResultSet rs;
        String a;
        stm = conexion.createStatement();
        rs = stm.executeQuery("select column_name from all_tab_columns where table_name = '" + table + "'");
        //getColumnNames(rs);
        while (rs.next()) {
            a = rs.getString("COLUMN_NAME");
           
            vec.add(a);
        }
        return vec;
    }
  
}
