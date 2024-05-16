/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

import java.time.LocalDate;

/**
 *
 * @author danig
 */
public class Prestamo {

    private int id;
    private String Nombre;
    private int libro_Solicitidos;
    private LocalDate fecha_Inicio;
    private LocalDate fecha_fin;

    public Prestamo(int id, String Nombre, int libro_Solicitidos, LocalDate fecha_Inicio, LocalDate fecha_fin) {
        this.id = id;
        this.Nombre = Nombre;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getLibro_Solicitidos() {
        return libro_Solicitidos;
    }

    public void setLibro_Solicitidos(int libro_Solicitidos) {
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

            // Calcula la diferencia entre las fechas en días
      public int getDiasSolicitados() {

        int diasEntreFechas = (int) (fecha_fin.toEpochDay() - fecha_Inicio.toEpochDay());
        return diasEntreFechas;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", Nombre=" + Nombre + ", libro_Solicitidos=" + libro_Solicitidos + ", fecha_Inicio=" + fecha_Inicio + ", fecha_fin=" + fecha_fin + '}';
    }
    
  
    
    
    
}
