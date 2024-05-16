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

/**
 *
 * @author danig
 */
public class Manejador_Menu implements ActionListener {

    private FRM_Menu frmMenu;
    private Manejador_Login manejador_Login;

    public Manejador_Menu(Manejador_Login manejador_Login, Login login) {

        this.manejador_Login = manejador_Login;
        frmMenu = new FRM_Menu(login.getRol());
        frmMenu.getjRol().setText(login.getRol());
        frmMenu.setVisible(true);
        frmMenu.escuchadorMenu(this);
        
    } //Fin del metodo 

    public Manejador_Menu() {
        frmMenu = new FRM_Menu();
        frmMenu.setVisible(true);
        frmMenu.escuchadorMenu(this);
    } //Fin del metodo 

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toString()) {
            case "Registro Estudiantes":
                new Manejador_Estudiantes(this);
                frmMenu.dispose();
                break;

            case "Registro Libros":
                new Manejador_Libros(this);
                frmMenu.dispose();
                break;

            case "Registro Prestamos":
                new Manejador_Prestamos();
                frmMenu.dispose();
                break;

            case "Registro Bibliotecarios":
                new Manejador_Bibliotecario(this);
                frmMenu.dispose();
                break;

            case "Salir":
                JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                System.exit(0);
                break;
        } //Fin del switch 

    } //Fin del metodo 

} //Fin de la clase 
