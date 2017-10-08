package control;

import Modelo.SQLiteJDBC;
import modelo.*;
import java.util.ArrayList;
import Vista.*;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author cesar
 */
public class Control {

    //Modelo
    private Conexion model;
    //Vista
    private JFrame ventana;
    //Otros
    private ArrayList<Table> tablas;
    private ArrayList<TableSpace> tablespaces;
    private int nivel;
    private String rol;
    private SQLiteJDBC sqlite;

    public Control() {
        model = new Conexion();
        sqlite = new SQLiteJDBC();
        model.conectar();
        sqlite.conectar();
        try {
            //sqlite.query("drop table nivel");
            sqlite.query("CREATE TABLE nivel " + "(nivel INT not null, tabla TEXT NOT NULL, CONSTRAINT pk_nivel PRIMARY KEY (nivel,tabla))");
        } catch (Exception e) {
            //System.out.print(e);
        }
    }

    public void iniciar() throws InterruptedException {
        ventana = new Principal(this);
        ((Principal) ventana).init();
    }

    public void iniciarTablespaces(int nivel) {
        this.nivel = nivel;
        try {
            tablespaces = model.getSegmentos();
            ventana.dispose();
            ventana = new Tablespaces(this);
            ((Tablespaces) ventana).init(tablespaces);
        } catch (InterruptedException e) {
            System.out.print("No se pudieron cargar los nombres de los tablespaces");
        }
    }

    public void iniciarTablas(String tsp) {
        try {
            tablas = model.getTable(tsp);
            ventana.dispose();
            ventana = new Tablas(this);
            ((Tablas) ventana).init(tablas);
        } catch (Exception e) {
            System.out.print("Error cargando nombres de las tablas.");
        }
    }

    public void iniciarNiveles() {
        ventana.dispose();
        ventana = new Niveles(this);
        ((Niveles) ventana).init();
    }

    public void iniciarRoles() {
        ventana.dispose();
        ventana = new Roles(this);
        //roles.init();
    }

    public void atras(String accion) {
        if (accion.equals("Niveles")) {
            ventana.dispose();
            ventana = new Principal(this);
            ((Principal) ventana).init();
        } else if (accion.equals("Tablespaces")) {
            ventana.dispose();
            ventana = new Niveles(this);
            ((Niveles) ventana).init();
        } else if (accion.equals("Tablas")) {
            iniciarTablespaces(nivel);
        }
    }

    public void guardarModificacionesNiveles(HashMap<String,Boolean> acciones) {
        sqlite.insertarElementosNivel(nivel, acciones);
    }

    public HashMap<String,String> obtenerModificacionesNiveles() {
        HashMap<String,String> map = new HashMap<>();
        try {
            map = sqlite.obtenerElementosNivelPorNivel(nivel);
        } catch (Exception e) {
            System.out.print("No se pudo ejecutar.");
        }
        return map;
    }

}
