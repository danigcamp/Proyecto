/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.controlador;

import ucr.ac.cr.vista.FRM_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.modelo.Login;
import ucr.ac.cr.modelo.Registro_Login;

public class Manejador_Login implements ActionListener {

    private Login l;
    private FRM_Login fRM_Login;
    private Manejador_Menu manejador_Menu;
    private Registro_Login rl;

    public Manejador_Login() {
        this.fRM_Login = new FRM_Login();
        fRM_Login.setVisible(true);
        rl = new Registro_Login();
        fRM_Login.escuchadorMenu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Entrar":
                if (validarCampos()) {
                    l = new Login();
                    char[] contrasena = fRM_Login.getjContrasena().getPassword();
                    String contrasenaTexto = new String(contrasena);
                    l.setCarnet(fRM_Login.getjUsuario().getText());
                    l.setContrasena(contrasenaTexto);

                    Login login = rl.logiarse(l.getCarnet(), l.getContrasena());
                    if (login != null && login.getRol() != null) {
                        l.setRol(login.getRol());
                        fRM_Login.dispose();
                        new Manejador_Menu(this, login);
                    }
                }
                break;

            case "Atras":
                System.exit(0);
                break;
        }
    }

    private boolean validarCampos() {
        if (fRM_Login.getjUsuario().getText().isEmpty() || fRM_Login.getjContrasena().getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    public Login getL() {
        return l;
    }

    public void setL(Login l) {
        this.l = l;
    }

}
