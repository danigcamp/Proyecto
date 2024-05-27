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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;
import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Login;

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
    private Login login;

    public Manejador_Prestamos(Manejador_Menu menu, Login login) {
        rPrestamo = new Registro_Prestamo();
        frmPrestamo = new FRM_Prestamo(login);
        frmPrestamo.getTxtId().setText("" + rPrestamo.obtenerSiguienteId());
        frmPrestamo.getTxtCarnet().setText("" + login.getCarnet());

        this.login = login;
        this.menu = menu;

        frmPrestamo.setVisible(true);
        frmPrestamo.escuchadorMenu(this);
        frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);

    } //Fin de la clase 

    public Manejador_Prestamos(Manejador_Menu menu, ArrayList<Libro> listaLibros, Login login) {
        this.login = login;
        frmPrestamo = new FRM_Prestamo(login);
        rPrestamo = new Registro_Prestamo();
        frmPrestamo.getTxtId().setText("" + rPrestamo.obtenerSiguienteId());
        frmPrestamo.getTxtCarnet().setText("" + login.getCarnet());

        this.login = login;
        System.err.println("Entra");
        this.listaLibros = listaLibros;
        this.menu = menu;

        frmPrestamo.setVisible(true);
        frmPrestamo.escuchadorMenu(this);
        frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
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
                if (login.getRol().equalsIgnoreCase("Estudiante")) {
                    buscarEstudiate();
                } else {
                    buscarBibliotecario();
                }

                break;

            case "Salir":
                salirDelSistema();
                break;
        }
        frmPrestamo.getTxtCarnet().setText("" + login.getCarnet());
    }

    private void agregar() {
        if (validarCampos()) {
            logic();
            rPrestamo.agregarPrestamo(p);
            JOptionPane.showMessageDialog(null, "Libro agregado: " + p.toString());
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
            frmPrestamo.getTxtId().setText("" + rPrestamo.obtenerSiguienteId());
        }
    }

    private void modificar() {
        if (validarCampos() && login.getRol().equalsIgnoreCase("Estudiante") && p.getCarnet() == login.getCarnet()) {
            logic();
            rPrestamo.modificarPrestamo(p);
            JOptionPane.showMessageDialog(null, "Libro modificado: " + p.toString());
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
        } else if (validarCampos() && login.getRol().equalsIgnoreCase("Bibliotecario")) {
            logic();
            rPrestamo.modificarPrestamo(p);
            JOptionPane.showMessageDialog(null, "Libro modificado: " + p.toString());
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
        }
    }

    private void eliminar() {

        if (!p.getCarnet().isEmpty() && login.getRol().equalsIgnoreCase("Estudiante") && p.getCarnet() == login.getCarnet()) {
            logic();
            rPrestamo.eliminarPrestamo(p);
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
            frmPrestamo.getTxtId().setText("" + rPrestamo.obtenerSiguienteId());
        } else if (!p.getCarnet().isEmpty() && login.getRol().equalsIgnoreCase("Bibliotecario")) {
            logic();
            rPrestamo.eliminarPrestamo(p);
            frmPrestamo.actualizarListaPrestamoATabla(rPrestamo);
            limpiarTxt();
            frmPrestamo.getTxtId().setText("" + rPrestamo.obtenerSiguienteId());
        }

    }

    private void buscarEstudiate() {
        if (!frmPrestamo.getTxtCarnet().getText().isEmpty()) {
            this.p = rPrestamo.buscarPrestamoEstudiante(frmPrestamo.getTxtCarnet().getText());
            if (p != null) {
                frmPrestamo.getTxtId().setText(String.valueOf(p.getId()));
                frmPrestamo.getTxtCarnet().setText(p.getCarnet());

            }
        }
    }

    private void buscarBibliotecario() {
        if (!frmPrestamo.getTxtCarnet().getText().isEmpty()) {
            this.p = rPrestamo.buscarPrestamoBibliotecario(Integer.parseInt(frmPrestamo.getTxtId().getText()));
            if (p != null) {
                frmPrestamo.getTxtId().setText(String.valueOf(p.getId()));
                frmPrestamo.getTxtCarnet().setText(p.getCarnet());

            }
        }
    }

    private void salirDelSistema() {
        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
        frmPrestamo.dispose();
        menu = new Manejador_Menu(login);
    }

    private void logic() {

        String fechaSolicitadoTexto = frmPrestamo.getjSolicitado().getText();

        DateTimeFormatter formatterSolicitado = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDate fechaSolicitado = LocalDate.parse(fechaSolicitadoTexto, formatterSolicitado);

        String fechaEntregaTexto = frmPrestamo.getjFechaEntrega().getText();

        DateTimeFormatter formatterEntrega = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDate fechaEntrega = LocalDate.parse(fechaEntregaTexto, formatterEntrega);

        this.p = new Prestamo(
                Integer.parseInt(frmPrestamo.getTxtId().getText()),
                frmPrestamo.getTxtCarnet().getText(),
                listaLibros,
                fechaSolicitado,
                fechaEntrega
        );
    }

    private boolean validarCampos() {
        System.err.println("sixe" + frmPrestamo.getComboLibros().getItemCount());
        if (frmPrestamo.getTxtCarnet().getText().isEmpty() || frmPrestamo.getTxtId().getText().isEmpty()
                || frmPrestamo.getjFechaEntrega().getText().isEmpty()
                || frmPrestamo.getjSolicitado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos y escoja los libros despectivos.");
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
