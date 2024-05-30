/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {

    private int id;
    private String carnet;
    private ArrayList <Libro> libro_Solicitidos;
    private LocalDate fecha_Inicio;
    private LocalDate fecha_fin;

    public Prestamo() {
    }

    public Prestamo(int id, String carnet, ArrayList<Libro> libro_Solicitidos, LocalDate fecha_Inicio, LocalDate fecha_fin) {
        this.id = id;
        this.carnet = carnet;
        this.libro_Solicitidos = libro_Solicitidos;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public ArrayList<Libro> getLibro_Solicitidos() {
        return libro_Solicitidos;
    }

    public void setLibro_Solicitidos(ArrayList<Libro> libro_Solicitidos) {
        this.libro_Solicitidos = libro_Solicitidos;
    }

    public LocalDate getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(LocalDate fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", carnet=" + carnet + ", libro_Solicitidos=" + libro_Solicitidos + ", fecha_Inicio=" + fecha_Inicio + ", fecha_fin=" + fecha_fin + '}';
    }

  
}
