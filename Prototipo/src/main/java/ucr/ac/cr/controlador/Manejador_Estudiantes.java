/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import ucr.ac.cr.modelo.Estudiante;
import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Registro_Estudiante;
import ucr.ac.cr.vista.FRM_Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.Login;

public class Manejador_Estudiantes implements ActionListener {

    private Manejador_Menu menu;
    Estudiante e;
    FRM_Estudiante frmEstudiante;
    Registro_Estudiante rE;
private Login login;
    public Manejador_Estudiantes(Manejador_Menu menu, Login login) {
        this.login = login;
        this.menu = menu;
        rE = new Registro_Estudiante();
        frmEstudiante = new FRM_Estudiante();
        frmEstudiante.setVisible(true);
        frmEstudiante.escuchadorMenu(this);
        frmEstudiante.actualizarListaLibroATabla(rE);
    } //Fin de la clase 

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar":
                agregarEstudiante();
                break;

            case "Modificar":
                modificarEstudiante();
                break;

            case "Eliminar":
                eliminarEstudiante();
                break;

            case "Buscar":
                buscarEstudiante();
                break;

            case "Salir":
                salirDelSistema();
                break;
        }

    }

    private void agregarEstudiante() {
        if (validarCampos()) {
            logic();
            rE.agregarEstudiante(e);
            JOptionPane.showMessageDialog(null, "Libro agregado: " + e.toString());
            frmEstudiante.actualizarListaLibroATabla(rE);
            limpiarTxt();
        }
    }

    private void modificarEstudiante() {
        if (validarCampos()) {
            logic();
            rE.modificarEstudiante(e);
            JOptionPane.showMessageDialog(null, "Libro modificado: " + e.toString());
            frmEstudiante.actualizarListaLibroATabla(rE);
            limpiarTxt();
        }
    }

    private void eliminarEstudiante() {
        if (validarCampos()) {
            logic();
            rE.eliminarEstudiante(e);
            frmEstudiante.actualizarListaLibroATabla(rE);
            limpiarTxt();
        }
    }

    private void buscarEstudiante() {
        if (!frmEstudiante.getTxtCarnet().getText().isEmpty()) {
      
           this. e = rE.buscarEstudiante(frmEstudiante.getTxtCarnet().getText());
            if (e != null) {
                frmEstudiante.getTxtNombre().setText(e.getNombre());
                frmEstudiante.getTxtLibrosSolicitados().setText(String.valueOf(e.getLibros_Solicitados()));
                frmEstudiante.getTxtCelular().setText(String.valueOf(e.getNumero_Telefonico()));
                frmEstudiante.getTxtCarnet().setText(e.getCarnet());
                frmEstudiante.getjContrasena().setText(e.getContrasena());
            }
        }
    }

    private void salirDelSistema() {
        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
        frmEstudiante.dispose();
        menu = new Manejador_Menu(login);
    }

    private void logic() {
//(String carnet, int numero_Telefonico, String nombre, int libros_Solicitados, String Contrasena)

        char[] contrasena = frmEstudiante.getjContrasena().getPassword();

        String contrasenaTexto = new String(contrasena);
        this.e = new Estudiante(
                frmEstudiante.getTxtCarnet().getText(),
                Integer.parseInt(frmEstudiante.getTxtCelular().getText()),
                frmEstudiante.getTxtNombre().getText(),
                Integer.parseInt(frmEstudiante.getTxtLibrosSolicitados().getText()),
                contrasenaTexto
        );
    }

    private boolean validarCampos() {
        char[] contrasena = frmEstudiante.getjContrasena().getPassword();

        if (frmEstudiante.getTxtCarnet().getText().isEmpty() || frmEstudiante.getTxtCelular().getText().isEmpty()
                || frmEstudiante.getTxtNombre().getText().isEmpty() || frmEstudiante.getTxtLibrosSolicitados().getText().isEmpty()
                || contrasena.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    public void limpiarTxt() {
        frmEstudiante.getTxtNombre().setText("");
        frmEstudiante.getTxtLibrosSolicitados().setText("");
        frmEstudiante.getTxtCelular().setText("");
        frmEstudiante.getTxtCarnet().setText("");
        frmEstudiante.getjContrasena().setText("");
    }

} //Fin de la clase 
