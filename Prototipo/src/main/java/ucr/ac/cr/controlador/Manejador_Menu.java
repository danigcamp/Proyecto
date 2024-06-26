/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import ucr.ac.cr.vista.FRM_Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.Login;

public class Manejador_Menu implements ActionListener {

    private FRM_Menu frmMenu;
    private Manejador_Login manejador_Login;
    private Login login;

    public Manejador_Menu(Manejador_Login manejador_Login, Login login) {
        this.login = login;
        this.manejador_Login = manejador_Login;
        frmMenu = new FRM_Menu(login.getRol());
        frmMenu.getjRol().setText(login.getRol());
        frmMenu.setVisible(true);
        frmMenu.escuchadorMenu(this);

    } //Fin del metodo 

    public Manejador_Menu(Login login) {
        this.login = login;
        frmMenu = new FRM_Menu(login.getRol());
        frmMenu.getjRol().setText(login.getRol());
        frmMenu.setVisible(true);
        frmMenu.escuchadorMenu(this);
    } //Fin del metodo 

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toString()) {
            case "Registro Estudiantes":
                if (login.getRol().equals("Bibliotecario")) {
                    new Manejador_Estudiantes(this, login);
                    frmMenu.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Acesso solo para bibliotecarios");
                }
                break;

            case "Registro Libros":
                if (login.getRol().equals("Bibliotecario")) {
                    new Manejador_Libros(this, login);
                    frmMenu.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Acesso solo para bibliotecarios");
                }

                break;

            case "Registro Prestamos":

                new Manejador_Prestamos(this, login);
                frmMenu.dispose();
                break;

            case "Registro Bibliotecarios":
                if (login.getRol().equals("Bibliotecario")) {
                    new Manejador_Bibliotecario(this, login);
                    frmMenu.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Acesso solo para bibliotecarios");
                }

                break;
            case "¡Solicita tu Libro Ahora!":

                new Manejador_Prestamos(this, login);
                frmMenu.dispose();
                break;
            case "Generar reporte":

                new Manejador_Reporte(this, login);
                frmMenu.dispose();

                break;

            case "Salir":
                JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                System.exit(0);
                break;
        } //Fin del switch 

    } //Fin del metodo 

    public Manejador_Login getManejador_Login() {
        return manejador_Login;
    }

    public void setManejador_Login(Manejador_Login manejador_Login) {
        this.manejador_Login = manejador_Login;
    }

} //Fin de la clase 

