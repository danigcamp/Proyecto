/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Login;
import ucr.ac.cr.modelo.Registro_Libro;
import ucr.ac.cr.vista.FRM_Prestamo_BusquedaLibro;

/**
 *
 * @author anton
 */
public class Manejador_Prestamo_BusquedaLibro implements ActionListener {

    private Manejador_Menu menu;
    private ArrayList<Libro> listaLibrosPrestados = new ArrayList<>();
    private ArrayList<Libro> listaLibrosTabla = new ArrayList<>();
    private Libro libro;
    private FRM_Prestamo_BusquedaLibro frmPrestamos;
    private Registro_Libro registro_Libro;
    private final int TITULO = 0;
    private final int EDITORIAL = 1;
    private final int ANO = 2;
    private final int GENERO = 3;
    private final int AUTOR = 4;
private Login login;
    public Manejador_Prestamo_BusquedaLibro(Login login) {
        this.menu = menu;
        this.login = login;
        registro_Libro = new Registro_Libro();
        frmPrestamos = new FRM_Prestamo_BusquedaLibro();
        frmPrestamos.setVisible(true);
        frmPrestamos.escuchadorMenu(this);
        frmPrestamos.actualizarListaLibroATabla(registro_Libro);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar al prestamo":
                agregarLibro();
                break;

            case "Eliminar libro solicitado":
                eliminarLibro();
                break;

            case "Buscar":
                buscarLibro();
                break;

            case "Limpiar ":
                limpiar();
                break;

            case "Salir":
                salirDelSistema();
                break;
        }
    }

    private void limpiar() {

        frmPrestamos.getTxtID().setText("");
        frmPrestamos.getTxtAutor().setText("");
        frmPrestamos.getTxtEditorial().setText("");
        frmPrestamos.getTxtGenero().setText("");
        frmPrestamos.getTxtTitulo().setText("");
        frmPrestamos.getTxtAno().setText("");
        frmPrestamos.limpiarTabla();
        frmPrestamos.actualizarListaLibroATabla(registro_Libro);
    }

    private void agregarLibro() {
        frmPrestamos.actualizarListaLibroATabla(registro_Libro);
        if (!frmPrestamos.getTxtID().getText().isEmpty()) {
            libro = registro_Libro.buscarLibro(Integer.parseInt(frmPrestamos.getTxtID().getText()));
            boolean estado = libro.isEstado();
            if (libro != null && libro.isEstado() == true) {
                listaLibrosPrestados.add(libro);
                frmPrestamos.actualizarLibroATablaPrestamo(libro);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "El libro debe estar disponible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El id debe estar incluido para que el libro pueda ser agregado");
        }
    }

    private void eliminarLibro() {
        if (!frmPrestamos.getTxtID().getText().isEmpty()) {
            int idLibro = Integer.parseInt(frmPrestamos.getTxtID().getText());
            for (int i = 0; i < listaLibrosPrestados.size(); i++) {
                if (listaLibrosPrestados.get(i).getId() == idLibro) {
                    listaLibrosPrestados.remove(i);
                    frmPrestamos.actualizarListaLibroATablaAlBorrar(listaLibrosPrestados);
                    break;
                }
            }
        }
    }

    private void buscarLibro() {
        if (!frmPrestamos.getTxtID().getText().isEmpty()) {
            libro = registro_Libro.buscarLibro(Integer.parseInt(frmPrestamos.getTxtID().getText()));
            if (libro != null) {
                frmPrestamos.getTxtID().setText(String.valueOf(libro.getId()));
                frmPrestamos.getTxtTitulo().setText(libro.getTitulo());
                frmPrestamos.getTxtEditorial().setText(libro.getEditorial());
                frmPrestamos.getTxtAno().setText(String.valueOf(libro.getAno()));
                frmPrestamos.getTxtGenero().setText(libro.getGenero());
                frmPrestamos.getTxtAutor().setText(libro.getAutor());
                frmPrestamos.getTxtAno().setText(String.valueOf(libro.getAno()));
                frmPrestamos.actualizarListaLibroATablaID(libro);
                return;
            }
        } else if (!frmPrestamos.getTxtTitulo().getText().isEmpty()) {
            frmPrestamos.actualizarListaLibroATabla(registro_Libro, TITULO);
            return;
        } else if (!frmPrestamos.getTxtEditorial().getText().isEmpty()) {
            frmPrestamos.actualizarListaLibroATabla(registro_Libro, EDITORIAL);
            return;
        } else if (!frmPrestamos.getTxtAno().getText().isEmpty()) {
            frmPrestamos.actualizarListaLibroATabla(registro_Libro, ANO);
            return;
        } else if (!frmPrestamos.getTxtGenero().getText().isEmpty()) {
            frmPrestamos.actualizarListaLibroATabla(registro_Libro, GENERO);
            return;
        } else if (!frmPrestamos.getTxtAutor().getText().isEmpty()) {
            frmPrestamos.actualizarListaLibroATabla(registro_Libro, AUTOR);
            return;
        }
    }

    private void salirDelSistema() {
        if (listaLibrosPrestados != null) {
            new Manejador_Prestamos(menu, listaLibrosPrestados, login);
            frmPrestamos.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe agregar almenos un libro");
        }
    }
}
