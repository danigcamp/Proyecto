/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

public class Bibliotecario {

    private String carnet;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private int celular;

    public Bibliotecario(String carnet, String Nombre, String Apellidos, String Contrasena, int celular) {
        this.carnet = carnet;
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.contrasena = Contrasena;
        this.celular = celular;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.contrasena = Contrasena;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "carnet=" + carnet + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrasena=" + contrasena + ", celular=" + celular + '}';
    }

  



}
