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

/**
 *
 * @author danig
 */
public class Manejador_Login implements ActionListener {

    private final boolean ESTUDIANTE = true;
    private final boolean BIBLIOTECARIO = false;
    private boolean usuario;
    private Login l;
    private FRM_Login fRM_Login;
    private Manejador_Menu manejador_Menu;
    private Registro_Login rl;

    public Manejador_Login(Manejador_Menu manejador_Menu,boolean usuario) {
          this.usuario = usuario;
        this.fRM_Login = new FRM_Login();
        fRM_Login.setVisible(true);
        this.manejador_Menu = manejador_Menu;
        rl = new Registro_Login();
        fRM_Login.escuchadorMenu(this);
    }

    public Manejador_Login() {
      
        this.fRM_Login = new FRM_Login();
        fRM_Login.setVisible(true);
        rl = new Registro_Login();
        fRM_Login.escuchadorMenu(this);
    }

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
                        if(usuario==ESTUDIANTE)
                            new Manejador_Estudiantes(manejador_Menu);
                        if(usuario==BIBLIOTECARIO)
                            new Manejador_Bibliotecario(manejador_Menu);
                    }
                }
                break;

            case "Atras":
                new Manejador_Menu();
                fRM_Login.dispose();
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
