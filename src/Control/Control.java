/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import modelo.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.GregorianCalendar;


import Vista.*;


/**
 *
 * @author cesar
 */
public class Control {
    private Conexion model;
    private Vent1 ventIni;
    
    private ArrayList<String> tabSpa;
    private ArrayList<TableSpace> ta;
    private TableSpace tab_graf;
    
   
   private Calendar fecha;
    public Control() 
    {
        model= new Conexion();
        model.conectar();
        ventIni= new Vent1(this);
        tabSpa= new ArrayList<>();
        ta = new ArrayList<>();
         tab_graf= new TableSpace();
       
//
//        sqlite.conectar();
//         sqlite.query("drop table TB_SPACES");
//         sqlite.conectar();
//         sqlite.query("drop table Hist");
//         sqlite.conectar();
//         sqlite.query("CREATE TABLE TB_SPACES " + "(fecha TEXT not null,nombre TEXT NOT NULL, MB_TABLAS float not null, usado float NOT NULL,TasaTrans float not null,registros INT NOT NULL)");
//         sqlite.conectar();
//           sqlite.query("CREATE TABLE Hist " + "(fecha TEXT not null,nombre TEXT NOT NULL, uso INT not null, porcentaje INT NOT NULL)");
//          sqlite.conectar();
//         sqlite.query("drop table HWM");
//         sqlite.conectar();
//         sqlite.query("CREATE TABLE HWM " + "(nombre TEXT NOT NULL, HWM INT not null)");

         fecha=  new GregorianCalendar(); 
 }
    
    public void iniciar() throws InterruptedException 
    {        
        ta= model.getSegmentos();
       
        ventIni.init(ta);
        
    }
    
   public void iniciarVent2(String tsp) throws SQLException 
   { 
           ArrayList<Table> vec =  model.getTable(tsp);
           ventIni.dispose();
        Vent2 ven2= new Vent2(this);
           ven2.init(vec);
       
   }

  public void atras () throws InterruptedException, SQLException
  { ta=null;
      ta= model.getSegmentos();
      ventIni= new Vent1(this);
        ventIni.init(ta);
  }
 
 
}
