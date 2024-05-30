/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.vista;

import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Registro_Libro;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FRM_Libros extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Libros
     */
    public FRM_Libros() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);

    }

    public void escuchadorMenu(ActionListener manejador) {
        agregar.addActionListener(manejador);
        modificar.addActionListener(manejador);
        eliminar.addActionListener(manejador);
        buscar.addActionListener(manejador);
        Salir.addActionListener(manejador);
    } //Fin del metodo 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        agregar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        registroEstudiantes = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("Editorial");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregar.setBackground(new java.awt.Color(204, 255, 204));
        agregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agregar.setText("Agregar Libro");
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        modificar.setBackground(new java.awt.Color(204, 255, 204));
        modificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modificar.setText("Modificar");
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Titulo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("Autor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        eliminar.setBackground(new java.awt.Color(204, 255, 204));
        eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eliminar.setText("Eliminar");
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("Genero");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        buscar.setBackground(new java.awt.Color(204, 255, 204));
        buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buscar.setText("Buscar");
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        Salir.setBackground(new java.awt.Color(204, 255, 204));
        Salir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Salir.setText("Salir");
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("Estado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        txtTitulo.setBackground(new java.awt.Color(255, 204, 204));
        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 150, -1));

        txtGenero.setBackground(new java.awt.Color(255, 204, 204));
        txtGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, -1));

        txtAutor.setBackground(new java.awt.Color(255, 204, 204));
        txtAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        getContentPane().add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 91, -1));

        registroEstudiantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registroEstudiantes.setForeground(new java.awt.Color(255, 153, 153));
        registroEstudiantes.setText("Registro Libros");
        getContentPane().add(registroEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("*El id es autoincremental");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 20));

        txtID.setBackground(new java.awt.Color(255, 204, 204));
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 70, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("Editorial");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtEditorial.setBackground(new java.awt.Color(255, 204, 204));
        txtEditorial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 138, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 102));
        jLabel10.setText("Ano");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtAno.setBackground(new java.awt.Color(255, 204, 204));
        txtAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 150, -1));

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Libre");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jRadioButton2.setText("En uso");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Editorial", "Ano", "Genero", "Autor", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 450, 290));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("ID");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FRM_Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Libros().setVisible(true);
            }
        });
    }

    public void actualizarListaLibroATabla(Registro_Libro registroLibro) {
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();

        if (registroLibro.getListaLibros().isEmpty()) {
            modeloTabla.setRowCount(0); // Limpiar la tabla
        } else {
            modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos libros

            for (Libro libro : registroLibro.getListaLibros()) {
                Object[] fila = {
                    libro.getId(),
                    libro.getTitulo(),
                    libro.getEditorial(),
                    libro.getAno(),
                    libro.getGenero(),
                    libro.getAutor(),
                    (boolean) libro.isEstado()
                };
                modeloTabla.addRow(fila);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton agregar;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel registroEstudiantes;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

    public JButton getSalir() {
        return Salir;
    }

    public void setSalir(JButton Salir) {
        this.Salir = Salir;
    }

    public JButton getAgregar() {
        return agregar;
    }

    public void setAgregar(JButton agregar) {
        this.agregar = agregar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public void setBuscar(JButton buscar) {
        this.buscar = buscar;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public void setEliminar(JButton eliminar) {
        this.eliminar = eliminar;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JRadioButton getjRadioButton1() {
        return jRadioButton1;
    }

    public void setjRadioButton1(JRadioButton jRadioButton1) {
        this.jRadioButton1 = jRadioButton1;
    }

    public JRadioButton getjRadioButton2() {
        return jRadioButton2;
    }

    public void setjRadioButton2(JRadioButton jRadioButton2) {
        this.jRadioButton2 = jRadioButton2;
    }

    public JButton getModificar() {
        return modificar;
    }

    public void setModificar(JButton modificar) {
        this.modificar = modificar;
    }

    public JLabel getRegistroEstudiantes() {
        return registroEstudiantes;
    }

    public void setRegistroEstudiantes(JLabel registroEstudiantes) {
        this.registroEstudiantes = registroEstudiantes;
    }

    public JTextField getTxtAno() {
        return txtAno;
    }

    public void setTxtAno(JTextField txtAno) {
        this.txtAno = txtAno;
    }

    public JTextField getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(JTextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public JTextField getTxtEditorial() {
        return txtEditorial;
    }

    public void setTxtEditorial(JTextField txtEditorial) {
        this.txtEditorial = txtEditorial;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(JTextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

}
