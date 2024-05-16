/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author danig
 */
public class Registro_Prestamo {

    private ArrayList<Prestamo> listaPrestamos;

    public Registro_Prestamo() {
    }

    public Registro_Prestamo(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    public void modificarPrestamo(Prestamo prestamo) {
        boolean encontrado = false;
        int i = listaPrestamos.size() - 1;
        while (!encontrado && 0 <= i) {
            if (prestamo == listaPrestamos.get(i)) {
                encontrado = true;
                listaPrestamos.set(i, prestamo);
                JOptionPane.showMessageDialog(null, "Se modificó el préstamo");
            }
            i--;
        }
    }

    public Prestamo buscarPrestamo(int id) {
        boolean encontrado = false;
        int i = listaPrestamos.size() - 1;
        while (!encontrado && 0 <= i) {
            if (id == listaPrestamos.get(i).getId()) {
                encontrado = true;
                Prestamo prestamoEncontrado = listaPrestamos.remove(i);
                JOptionPane.showMessageDialog(null, "Se encontró el préstamo");
                return prestamoEncontrado;
            }
            i--;
        }
        JOptionPane.showMessageDialog(null, "No se encontró el préstamo");
        return null;
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getId() == prestamo.getId()) {
                listaPrestamos.remove(i);
                break; 
            }
        }
    }
    public void getMatrizPrestamo() {

    }

    public void getComboPrestamo() {

    }
}
