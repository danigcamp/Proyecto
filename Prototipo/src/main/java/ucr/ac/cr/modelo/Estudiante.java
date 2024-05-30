/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

public class Estudiante {

    private String carnet;
    private int numero_Telefonico;
    private String nombre;
    private int libros_Solicitados;
    private String Contrasena;

    public Estudiante(String carnet, int numero_Telefonico, String nombre, int libros_Solicitados, String Contrasena) {
        this.carnet = carnet;
        this.numero_Telefonico = numero_Telefonico;
        this.nombre = nombre;
        this.libros_Solicitados = libros_Solicitados;
        this.Contrasena = Contrasena;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getNumero_Telefonico() {
        return numero_Telefonico;
    }

    public void setNumero_Telefonico(int numero_Telefonico) {
        this.numero_Telefonico = numero_Telefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLibros_Solicitados() {
        return libros_Solicitados;
    }

    public void setLibros_Solicitados(int libros_Solicitados) {
        this.libros_Solicitados = libros_Solicitados;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carnet=" + carnet + ", numero_Telefonico=" + numero_Telefonico + ", nombre=" + nombre + ", libros_Solicitados=" + libros_Solicitados + ", Contrasena=" + Contrasena + '}';
    }

    

   
}
