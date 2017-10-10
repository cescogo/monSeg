/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cesar
 */
public class ColumnaTabla {
    private String nombre,tsp,tabla;
    private boolean[] niveles;
    

    public ColumnaTabla(String nombre, String tsp,String tab) {
        this.nombre = nombre;
        niveles= new boolean[5];
        this.tsp=tsp;
        tabla=tab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTsp() {
        return tsp;
    }

    public void setTsp(String tsp) {
        this.tsp = tsp;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public boolean getNiveles(int pos) {
        return niveles[pos];
    }

    public void setNiveles(int pos, boolean niv) {
        niveles[pos] = niv;
    }
    
    
}
