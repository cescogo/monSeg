package control;

import modelo.*;
import java.util.ArrayList;
import Vista.*;
import javax.swing.JFrame;

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
    
    public Control() {
        model = new Conexion();
        model.conectar();
//        sqlite.conectar();
//        sqlite.query("drop table TB_SPACES");
//        sqlite.conectar();
//        sqlite.query("drop table Hist");
//        sqlite.conectar();
//        sqlite.query("CREATE TABLE TB_SPACES " + "(fecha TEXT not null,nombre TEXT NOT NULL, MB_TABLAS float not null, usado float NOT NULL,TasaTrans float not null,registros INT NOT NULL)");
//        sqlite.conectar();
//        sqlite.query("CREATE TABLE Hist " + "(fecha TEXT not null,nombre TEXT NOT NULL, uso INT not null, porcentaje INT NOT NULL)");
//        sqlite.conectar();
//        sqlite.query("drop table HWM");
//        sqlite.conectar();
//        sqlite.query("CREATE TABLE HWM " + "(nombre TEXT NOT NULL, HWM INT not null)");
    }

    public void iniciar() throws InterruptedException {
        ventana = new Principal(this);
        ((Principal)ventana).init();
    }

    public void iniciarTablespaces(int nivel) {
        this.nivel = nivel;
        try {
            tablespaces = model.getSegmentos();
            ventana.dispose();
            ventana = new Tablespaces(this);
            ((Tablespaces)ventana).init(tablespaces);
        } catch (InterruptedException e) {
            System.out.print("No se pudieron cargar los nombres de los tablespaces");
        }
    }

    public void iniciarTablas(String tsp) {
        try {
            tablas = model.getTable(tsp);
            ventana.dispose();
            ventana = new Tablas(this);
            ((Tablas)ventana).init(tablas);
        } catch (Exception e) {
            System.out.print("Error cargando nombres de las tablas.");
        }
    }

    public void iniciarNiveles() {
        ventana.dispose();
        ventana = new Niveles(this);
        ((Niveles)ventana).init();
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
            ((Principal)ventana).init();
        } else if (accion.equals("Tablespaces")) {
            ventana.dispose();
            ventana = new Niveles(this);
            ((Niveles)ventana).init();
        }
        else if (accion.equals("Tablas")) {
            iniciarTablespaces(nivel);
        }
    }
}
