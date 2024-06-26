/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.vista;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import ucr.ac.cr.controlador.Manejador_Login;

public class FRM_Menu extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Menu
     */
    public FRM_Menu(String rol) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);

        if (rol.equals("Estudiante")) {
            jmiRegistroBibliotecario.setVisible(false);
            jmiRegistroEstudiantes.setVisible(false);
            jmiRegistroLibros.setVisible(false);
        }
    }

    public FRM_Menu() {
            this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    public void escuchadorMenu(ActionListener manejador) {
        jmiRegistroEstudiantes.addActionListener(manejador);
        jmiRegistroLibros.addActionListener(manejador);
        jmiRegistroPrestamos.addActionListener(manejador);
        jmiRegistroBibliotecario.addActionListener(manejador);
        jmiSalir.addActionListener(manejador);
        jButton1.addActionListener(manejador);
    } //Fin del metodo 

    public JLabel getjRol() {
        return jRol;
    }

    public void setjRol(JLabel jRol) {
        this.jRol = jRol;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jRol = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRol1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiRegistroLibros = new javax.swing.JMenuItem();
        jmiRegistroPrestamos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiRegistroEstudiantes = new javax.swing.JMenuItem();
        jmiRegistroBibliotecario = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiSalir2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiSalir1 = new javax.swing.JMenuItem();
        jmiSalir3 = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jLabel1.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Biblioteca Universitaria");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRol.setFont(new java.awt.Font("Lucida Calligraphy", 0, 36)); // NOI18N
        jRol.setForeground(new java.awt.Color(255, 51, 102));

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("BIBLIOTECA UNIVERSITARIA");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("¡Solicita tu Libro Ahora!");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRol1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 24)); // NOI18N
        jRol1.setForeground(new java.awt.Color(255, 51, 102));
        jRol1.setText("Rol:");

        jMenu3.setText("Registrar datos");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jmiRegistroLibros.setText("Registro Libros");
        jmiRegistroLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.add(jmiRegistroLibros);

        jmiRegistroPrestamos.setText("Registro Prestamos");
        jmiRegistroPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.add(jmiRegistroPrestamos);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Administracion de usuario");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jmiRegistroEstudiantes.setText("Registro Estudiantes");
        jmiRegistroEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu5.add(jmiRegistroEstudiantes);

        jmiRegistroBibliotecario.setText("Registro Bibliotecarios");
        jmiRegistroBibliotecario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu5.add(jmiRegistroBibliotecario);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Reportes");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jmiSalir2.setText("Generar reporte");
        jmiSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmiSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalir2ActionPerformed(evt);
            }
        });
        jMenu6.add(jmiSalir2);

        jMenuBar1.add(jMenu6);

        jMenu4.setText("Opciones");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jmiSalir1.setText("About");
        jmiSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmiSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalir1ActionPerformed(evt);
            }
        });
        jMenu4.add(jmiSalir1);

        jmiSalir3.setText("Cerrar sesion");
        jmiSalir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmiSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalir3ActionPerformed(evt);
            }
        });
        jMenu4.add(jmiSalir3);

        jmiSalir.setText("Salir");
        jmiSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.add(jmiSalir);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRol1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRol1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRol, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalir1ActionPerformed
        // TODO add your handling code here:
        FRM_About frm_About = new FRM_About();
        frm_About.setVisible(true);
    }//GEN-LAST:event_jmiSalir1ActionPerformed

    private void jmiSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiSalir2ActionPerformed

    private void jmiSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalir3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Manejador_Login();
    }//GEN-LAST:event_jmiSalir3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jRol;
    private javax.swing.JLabel jRol1;
    private javax.swing.JMenuItem jmiRegistroBibliotecario;
    private javax.swing.JMenuItem jmiRegistroEstudiantes;
    private javax.swing.JMenuItem jmiRegistroLibros;
    private javax.swing.JMenuItem jmiRegistroPrestamos;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiSalir1;
    private javax.swing.JMenuItem jmiSalir2;
    private javax.swing.JMenuItem jmiSalir3;
    // End of variables declaration//GEN-END:variables
} //Fin de la clase 
