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
import javax.swing.JOptionPane;

/**
 *
 * @author danig
 */
public class Manejador_Prestamos implements ActionListener {

    Registro_Prestamo registro_Prestamo;
    FRM_Prestamo frmPrestamo;
    Prestamo prestamo;

    public Manejador_Prestamos() {
        frmPrestamo = new FRM_Prestamo();
        frmPrestamo.setVisible(true);
    } //Fin de la clase 

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toString()) {
            case "Agregar":
                registro_Prestamo.agregarPrestamo(prestamo);
                break;

            case "Modificar":

                break;

            case "Eliminar":

                break;

            case "Buscar":

                break;

            case "Salir":
                JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                System.exit(0);
                break;
        } //Fin del switch 

    } //Fin del metodo 

} //Fin de la clase 
