/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Registro_Libro;
import ucr.ac.cr.vista.FRM_Libros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.Login;

/**
 *
 * @author danig
 */
public class Manejador_Libros implements ActionListener {
    
    private Libro libro;
    private Registro_Libro registro_Libro;
    private FRM_Libros frmLibros;
    private Manejador_Menu menu;
    private final Login login;
    
    public Manejador_Libros(Manejador_Menu menu, Login login) {
        this.login = login;
        this.menu = menu;
        registro_Libro = new Registro_Libro();
        frmLibros = new FRM_Libros();
        frmLibros.setVisible(true);
        frmLibros.escuchadorMenu(this);
        frmLibros.actualizarListaLibroATabla(registro_Libro);
        frmLibros.getTxtID().setText("" + registro_Libro.obtenerSiguienteId());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar Libro":
                agregarLibro();
                break;
            
            case "Modificar":
                modificarLibro();
                break;
            
            case "Eliminar":
                eliminarLibro();
                break;
            
            case "Buscar":
                buscarLibro();
                break;
            
            case "Salir":
                salirDelSistema();
                break;
        }
    }
    
    private void agregarLibro() {
        if (validarCampos()) {
            logic();
            registro_Libro.agregarLibro(libro);
            JOptionPane.showMessageDialog(null, "Libro agregado: " + libro.toString());
            frmLibros.actualizarListaLibroATabla(registro_Libro);
            
            limpiarTxt();
            frmLibros.getTxtID().setText("" + registro_Libro.obtenerSiguienteId());
        }
    }
    
    private void modificarLibro() {
        if (validarCampos()) {
            logic();
            registro_Libro.modificarLibro(libro);
            JOptionPane.showMessageDialog(null, "Libro modificado: " + libro.toString());
            frmLibros.actualizarListaLibroATabla(registro_Libro);
            
            limpiarTxt();
        }
    }
    
    private void eliminarLibro() {
        if (validarCampos()) {
            logic();
            registro_Libro.eliminarLibro(libro);
            JOptionPane.showMessageDialog(null, "Libro eliminado: " + libro.toString());
            frmLibros.actualizarListaLibroATabla(registro_Libro);
            limpiarTxt();
            frmLibros.getTxtID().setText("" + registro_Libro.obtenerSiguienteId());
        }
    }
    
    private void buscarLibro() {
        if (!frmLibros.getTxtID().getText().isEmpty()) {
            libro = registro_Libro.buscarLibro(Integer.parseInt(frmLibros.getTxtID().getText()));
            if (libro != null) {
                frmLibros.getTxtID().setText(String.valueOf(libro.getId()));
                frmLibros.getTxtTitulo().setText(libro.getTitulo());
                frmLibros.getTxtEditorial().setText(libro.getEditorial());
                frmLibros.getTxtAno().setText(String.valueOf(libro.getAno()));
                frmLibros.getTxtGenero().setText(libro.getGenero());
                frmLibros.getTxtAutor().setText(libro.getAutor());
                if (libro.isEstado()) {
                    frmLibros.getjRadioButton1().setSelected(true);
                } else {
                    frmLibros.getjRadioButton2().setSelected(true);
                }
                
            }
        }
    }
    
    private void salirDelSistema() {
        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
        frmLibros.dispose();
        new Manejador_Menu(login);
    }
    
    private void logic() {
        boolean estado;
        
        estado = frmLibros.getjRadioButton1().isSelected();
        
        this.libro = new Libro(
                Integer.parseInt(frmLibros.getTxtID().getText()),
                frmLibros.getTxtTitulo().getText(),
                frmLibros.getTxtEditorial().getText(),
                estado,
                Integer.parseInt(frmLibros.getTxtAno().getText()),
                frmLibros.getTxtGenero().getText(),
                frmLibros.getTxtAutor().getText()
        );
    }
    
    private boolean validarCampos() {
        if (frmLibros.getTxtID().getText().isEmpty() || frmLibros.getTxtTitulo().getText().isEmpty()
                || frmLibros.getTxtEditorial().getText().isEmpty() || frmLibros.getTxtAno().getText().isEmpty()
                || frmLibros.getTxtGenero().getText().isEmpty() || frmLibros.getTxtAutor().getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }
        
        return true;
    }
    
    public void limpiarTxt() {
        frmLibros.getTxtID().setText("");
        frmLibros.getTxtTitulo().setText("");
        frmLibros.getTxtEditorial().setText("");
        frmLibros.getTxtAno().setText("");
        frmLibros.getTxtGenero().setText("");
        frmLibros.getTxtAutor().setText("");
        
        frmLibros.getjRadioButton1().setSelected(true);
        
        frmLibros.getjRadioButton2().setSelected(false);
        
    }
}
