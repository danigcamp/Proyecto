/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.vista;

/**
 *
 * @author anton
 */
public class FRM_About extends javax.swing.JFrame {

    /**
     * Creates new form FRM_About
     */
    public FRM_About() {
           this.setUndecorated(true);
        initComponents();
        jTextPane2.setText("Acerca de la Aplicación del Sistema Transaccional\n"
                + "Descripción General\n"
                + "La Aplicación del Sistema Transaccional es una solución informática desarrollada por un grupo de cuatro estudiantes de la Universidad de Costa Rica, Sede Regional del Pacífico, como parte del programa de Informática Empresarial. Esta aplicación tiene como objetivo abordar y optimizar los procesos transaccionales utilizando técnicas avanzadas de programación y principios de diseño centrados en el usuario.\n"
                + "\n"
                + "Características Principales\n"
                + "Registro y Administración de Usuarios: Un módulo robusto que permite a los usuarios registrarse, iniciar sesión y gestionar sus perfiles de manera segura.\n"
                + "Gestión de Datos: Herramientas completas para registrar, validar y almacenar datos transaccionales de forma permanente, utilizando archivos JSON para una gestión eficiente de datos.\n"
                + "Informes y Análisis: Generación de informes detallados y análisis a través de tablas dinámicas con capacidades de filtrado, proporcionando valiosas visualizaciones e insights de datos.\n"
                + "Interfaz Gráfica de Usuario: Una interfaz intuitiva y estéticamente agradable diseñada para mejorar la experiencia y accesibilidad del usuario.\n"
                + "Manejo de Eventos: Componentes responsivos que gestionan de manera eficaz las interacciones y eventos del usuario, asegurando una experiencia fluida e interactiva.\n"
                + "Herramientas de Desarrollo y Estándares\n"
                + "Lenguaje de Programación: Java\n"
                + "Gestión de Proyectos: Maven\n"
                + "Entorno de Desarrollo Integrado (IDE): Apache NetBeans\n"
                + "Control de Versiones: GitHub, con un mínimo de 5 commits significativos\n"
                + "Diseño y Arquitectura: Principios de programación orientada a objetos, incluyendo herencia, polimorfismo y el uso de clases abstractas.\n"
                + "Objetivos\n"
                + "Demostrar Competencias: Aplicar conocimientos teóricos en un contexto práctico para mostrar habilidades y competencias en programación.\n"
                + "Integrar Conocimientos: Combinar elementos lógicos y estéticos para desarrollar una aplicación funcional y visualmente atractiva.\n"
                + "Fomentar el Autoaprendizaje: Promover la capacidad de aprender de manera independiente a través de la investigación y la resolución de problemas.\n"
                + "Innovar Soluciones: Desarrollar un sistema innovador que aborde problemas del mundo real a través de una programación eficaz.");

        this.setSize(560, 360);
        this.setLocationRelativeTo(null);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jTextPane2.setEditable(false);
        jScrollPane2.setViewportView(jTextPane2);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
