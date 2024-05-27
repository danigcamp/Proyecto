/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.modelo.Login;
import ucr.ac.cr.modelo.Registro_Login;
import ucr.ac.cr.modelo.Registro_Prestamo;
import ucr.ac.cr.vista.FRM_Reporte;

/**
 *
 * @author danig
 */
public class Manejador_Reporte implements ActionListener {

    private final Manejador_Menu menu;
    private final Login login;
    private FRM_Reporte fRM_Reporte;
    private Registro_Prestamo prestamo;
    private Registro_Login registro_Login;

    public Manejador_Reporte(Manejador_Menu menu, Login login) {
        this.login = login;
        this.menu = menu;
        fRM_Reporte = new FRM_Reporte();
        fRM_Reporte.setVisible(true);
        prestamo = new Registro_Prestamo();
        registro_Login = new Registro_Login();
        fRM_Reporte.getTxtCarnet().setText(login.getCarnet());
        fRM_Reporte.escuchadorMenu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Reporte de logins":
                reporteLogins();
                break;

            case "Reporte de prestamos":
                reportePrestamo();
                break;

            case "Salir":
                salirDelSistema();
                break;
        }
    }

    public void reporteLogins() {
        if (logic()) {
        fRM_Reporte.llenarTablaConLogins(registro_Login.leerJSONEstudiantes());
        }else{
        fRM_Reporte.llenarTablaConLogins(registro_Login.leerJSON());
        }
    }

    public void reportePrestamo() {
        String reporte;
        if (logic()) {
            reporte = prestamo.generarReportePorCarnet(fRM_Reporte.getTxtCarnet().getText());
        } else {
            reporte = prestamo.generarReporteTodosPrestamos();
        }
        fRM_Reporte.llenarTablaConReporte(reporte);

    }

    public void salirDelSistema() {
        new Manejador_Menu(login);
        fRM_Reporte.dispose();
        }

    public boolean logic() {
        if (login.getRol().equalsIgnoreCase("Estudiante")) {
            return true;
        }
        return false;
    }
}
