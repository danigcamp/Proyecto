/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.vista;

import ucr.ac.cr.modelo.Libro;
import ucr.ac.cr.modelo.Registro_Libro;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danig
 */
public class FRM_Prestamo_BusquedaLibro extends javax.swing.JFrame {

    private Registro_Libro registro_Libro;

    /**
     * Creates new form FRM_Libros
     */
    public FRM_Prestamo_BusquedaLibro() {
        initComponents();
        registro_Libro = new Registro_Libro();
        this.setLocationRelativeTo(null);
    }

    public Registro_Libro getRegistro_Libro() {
        return registro_Libro;
    }

    public void setRegistro_Libro(Registro_Libro registro_Libro) {
        this.registro_Libro = registro_Libro;
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        registroEstudiantes1 = new javax.swing.JLabel();
        registroEstudiantes2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("Editorial");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregar.setBackground(new java.awt.Color(204, 255, 204));
        agregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agregar.setText("Agregar al prestamo");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, -1, -1));

        modificar.setBackground(new java.awt.Color(204, 255, 204));
        modificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modificar.setText("Guardar");
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

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
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("Genero");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        buscar.setBackground(new java.awt.Color(204, 255, 204));
        buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buscar.setText("Buscar");
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, -1));

        Salir.setBackground(new java.awt.Color(204, 255, 204));
        Salir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Salir.setText("Salir");
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

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
        registroEstudiantes.setText("Libros prestados");
        getContentPane().add(registroEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 450, 160));

        registroEstudiantes1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registroEstudiantes1.setForeground(new java.awt.Color(255, 153, 153));
        registroEstudiantes1.setText("Filtros de busqueda");
        getContentPane().add(registroEstudiantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        registroEstudiantes2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registroEstudiantes2.setForeground(new java.awt.Color(255, 153, 153));
        registroEstudiantes2.setText("Busqueda Libros");
        getContentPane().add(registroEstudiantes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 450, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarActionPerformed

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
            java.util.logging.Logger.getLogger(FRM_Prestamo_BusquedaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Prestamo_BusquedaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Prestamo_BusquedaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Prestamo_BusquedaLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Prestamo_BusquedaLibro().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel registroEstudiantes;
    private javax.swing.JLabel registroEstudiantes1;
    private javax.swing.JLabel registroEstudiantes2;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
