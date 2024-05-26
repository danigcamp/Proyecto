/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import ucr.ac.cr.modelo.Prestamo;
import ucr.ac.cr.modelo.Registro_Prestamo;
import ucr.ac.cr.vista.FRM_Prestamo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;
import ucr.ac.cr.modelo.Libro;

/**
 *
 * @author danig
 */
public class Manejador_Prestamos implements ActionListener {

    private ArrayList<Libro> listaLibros;
    private Manejador_Menu menu;
    Prestamo p;
    FRM_Prestamo frmPrestamo;
    Registro_Prestamo rPrestamo;

    public Manejador_Prestamos(Manejador_Menu menu) {
        this.menu = menu;
        rPrestamo = new Registro_Prestamo();
        frmPrestamo = new FRM_Prestamo();
        frmPrestamo.setVisible(true);
        frmPrestamo.escuchadorMenu(this);
        frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
    } //Fin de la clase 

    public Manejador_Prestamos(Manejador_Menu menu, ArrayList<Libro> listaLibros) {
        System.err.println("Entra");
        this.listaLibros = listaLibros;
        this.menu = menu;
        rPrestamo = new Registro_Prestamo();
        frmPrestamo = new FRM_Prestamo();
        frmPrestamo.setVisible(true);
        frmPrestamo.escuchadorMenu(this);
        frmPrestamo.llenarComboLibros(listaLibros);

    } //Fin de la clase 

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar":
                agregar();
                break;

            case "Modificar":
                modificar();
                break;

            case "Eliminar":
                eliminar();
                break;

            case "Buscar":
                if (menu.getManejador_Login().getL().getRol().equals("Estudiante")) {
                    buscarEstudiate();
                } else {
                    buscarBibliotecario();
                }

                break;

            case "Salir":
                salirDelSistema();
                break;
        }

    }

    private void agregar() {
        if (validarCampos()) {
            logic();
            rPrestamo.agregarPrestamo(p);
            JOptionPane.showMessageDialog(null, "Libro agregado: " + p.toString());
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
        }
    }

    private void modificar() {
        if (validarCampos()) {
            logic();
            rPrestamo.modificarPrestamo(p);
            JOptionPane.showMessageDialog(null, "Libro modificado: " + p.toString());
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
        }
    }

    private void eliminar() {
        if (validarCampos()) {
            logic();
            rPrestamo.eliminarPrestamo(p);
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
        }
    }

    private void buscarEstudiate() {
        if (!frmPrestamo.getTxtCarnet().getText().isEmpty()) {

            this.p = rPrestamo.buscarPrestamoEstudiante(frmPrestamo.getTxtCarnet().getText());
            if (p != null) {
                frmPrestamo.getTxtId().setText(String.valueOf(p.getId()));
                frmPrestamo.getTxtCarnet().setText(p.getCarnet());

                //hacer logica para guardar los libros del combo
                //hacer paseo de fechas
            }
        }
    }

    private void buscarBibliotecario() {
        if (!frmPrestamo.getTxtCarnet().getText().isEmpty()) {

            this.p = rPrestamo.buscarPrestamoEstudiante(frmPrestamo.getTxtCarnet().getText());
            if (p != null) {
                frmPrestamo.getTxtId().setText(String.valueOf(p.getId()));
                frmPrestamo.getTxtCarnet().setText(p.getCarnet());

                //hacer logica para guardar los libros del combo
                //hacer paseo de fechas
            }
        }
    }

    private void salirDelSistema() {
        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
        frmPrestamo.dispose();
        menu = new Manejador_Menu();
    }

    private void logic() {
//  public Prestamo(int id, String carnet, int libro_Solicitidos, LocalDate fecha_Inicio, LocalDate fecha_fin)
        String libros = "";

        this.p = new Prestamo(
                Integer.parseInt(frmPrestamo.getTxtId().getText()),
                frmPrestamo.getTxtCarnet().getText(),
                listaLibros,
                LocalDate.parse(frmPrestamo.getjSolicitado().getText()),
                LocalDate.parse(frmPrestamo.getjFechaEntrega().getText())
        );
    }

    private boolean validarCampos() {

        if (frmPrestamo.getTxtCarnet().getText().isEmpty() || frmPrestamo.getTxtId().getText().isEmpty()
                || listaLibros.isEmpty() || frmPrestamo.getjFechaEntrega().getText().isEmpty()
                || frmPrestamo.getjSolicitado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    public void limpiarTxt() {
        frmPrestamo.getTxtId().setText("");
        frmPrestamo.getTxtCarnet().setText("");
        frmPrestamo.getComboLibros().setSelectedIndex(0);
        listaLibros.clear();
        frmPrestamo.getjFechaEntrega().setText("");
        frmPrestamo.getjSolicitado().setText("");
    }

} //Fin de la clase 
