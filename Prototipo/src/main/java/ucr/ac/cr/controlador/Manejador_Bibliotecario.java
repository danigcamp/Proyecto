/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import ucr.ac.cr.modelo.Bibliotecario;
import ucr.ac.cr.modelo.Estudiante;
import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Registro_Bibliotecario;
import ucr.ac.cr.modelo.Registro_Estudiante;
import ucr.ac.cr.vista.FRM_Bibliotecario;
import ucr.ac.cr.vista.FRM_Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.Login;

/**
 *
 * @author danig
 */
public class Manejador_Bibliotecario implements ActionListener {

    private Manejador_Menu menu;
    Bibliotecario b;
    FRM_Bibliotecario frmBibliotecario;
    Registro_Bibliotecario rBibliotecario;
    private Login login;

    public Manejador_Bibliotecario(Manejador_Menu menu, Login login) {
        this.login = login;
        this.menu = menu;
        rBibliotecario = new Registro_Bibliotecario();
        frmBibliotecario = new FRM_Bibliotecario();
        frmBibliotecario.setVisible(true);
        frmBibliotecario.escuchadorMenu(this);
        frmBibliotecario.actualizarListaLibroATabla(rBibliotecario);
    } //Fin de la clase 

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar":
                agregarBibliotecario();
                break;

            case "Modificar":
                modificar();
                break;

            case "Eliminar":
                eliminar();
                break;

            case "Buscar":
                buscar();
                break;

            case "Salir":
                salirDelSistema();
                break;
        }
    }

    private void agregarBibliotecario() {
        if (validarCampos()) {
            logic();
            rBibliotecario.agregarBibliotecario(b);
            JOptionPane.showMessageDialog(null, "Bibliotecario agregado: " + b.toString());
            frmBibliotecario.actualizarListaLibroATabla(rBibliotecario);
            limpiarTxt();
        }
    }

    private void modificar() {
        if (validarCampos()) {
            logic();
            rBibliotecario.modificarBibliotecario(b);
            JOptionPane.showMessageDialog(null, "Bibliotecario modificado: " + b.toString());
            frmBibliotecario.actualizarListaLibroATabla(rBibliotecario);
            limpiarTxt();
        }
    }

    private void eliminar() {
        if (validarCampos()) {
            logic();
            rBibliotecario.eliminarBibliotecario(b);
            frmBibliotecario.actualizarListaLibroATabla(rBibliotecario);
            limpiarTxt();
        }
    }

    private void buscar() {
        if (!frmBibliotecario.getTxtCarnet().getText().isEmpty()) {
            b = rBibliotecario.buscarBibliotecario(frmBibliotecario.getTxtCarnet().getText());
            if (b != null) {
                frmBibliotecario.getTxtNombre().setText(b.getNombre());
                frmBibliotecario.getTxtApellidos().setText(b.getApellidos());
                frmBibliotecario.getTxtCelular().setText(String.valueOf(b.getCelular()));
                frmBibliotecario.getTxtCarnet().setText(b.getCarnet());
                frmBibliotecario.getjContrasena().setText(b.getContrasena());
            }
        }
    }

    private void salirDelSistema() {
        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
        frmBibliotecario.dispose();
        menu = new Manejador_Menu( login);
    }

    private void logic() {
// Bibliotecario(String carnet, String Nombre, String Apellidos, String Contrasena, int celular) {

        char[] contrasena = frmBibliotecario.getjContrasena().getPassword();

        String contrasenaTexto = new String(contrasena);
        this.b = new Bibliotecario(
                frmBibliotecario.getTxtCarnet().getText(),
                frmBibliotecario.getTxtNombre().getText(),
                frmBibliotecario.getTxtApellidos().getText(),
                contrasenaTexto,
                Integer.parseInt(frmBibliotecario.getTxtCelular().getText())
        );
    }

    private boolean validarCampos() {
        char[] contrasena = frmBibliotecario.getjContrasena().getPassword();

        if (frmBibliotecario.getTxtCarnet().getText().isEmpty() || frmBibliotecario.getTxtCelular().getText().isEmpty()
                || frmBibliotecario.getTxtNombre().getText().isEmpty() || frmBibliotecario.getTxtCelular().getText().isEmpty()
                || contrasena.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    public void limpiarTxt() {
        frmBibliotecario.getTxtNombre().setText("");
        frmBibliotecario.getTxtApellidos().setText("");
        frmBibliotecario.getTxtCelular().setText("");
        frmBibliotecario.getTxtCarnet().setText("");
        frmBibliotecario.getjContrasena().setText("");

    }

} //Fin de la clase 
