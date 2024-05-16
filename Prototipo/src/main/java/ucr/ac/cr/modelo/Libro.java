/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.modelo;

/**
 *
 * @author danig
 */
public class Libro {

    private int id;
    private String titulo;
    private String editorial;
    private boolean estado;
    private int ano;
    private String genero;
    private String autor;

    public Libro(int id, String titulo, String editorial, boolean estado, int ano, String genero, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.estado = estado;
        this.ano = ano;
        this.genero = genero;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + ", estado=" + estado + ", ano=" + ano + ", genero=" + genero + ", autor=" + autor + '}';
    }

    
    
    

}
