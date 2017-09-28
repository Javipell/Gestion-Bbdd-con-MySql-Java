/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author javier
 */
public class Acerca extends javax.swing.JFrame {

    /**
     * Creates new form Modificar
     */
    public Acerca() {
        initComponents();
        // centrar el formulario en la ventan
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

        jLabelIcono = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabelFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BasedeDatos2.jpg"))); // NOI18N
        jLabelIcono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelIconoMousePressed(evt);
            }
        });
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 370, 280));

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JAVIPELL@GMAIL.COM");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabel3.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GESTION DE BASES DE DATOS MYSQL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 153));
        jLabel4.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("(C) JAVIER PELLICENA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 153));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane1.setFont(new java.awt.Font("Lucida Console", 0, 15)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(0, 0, 153));
        jTextPane1.setText("Gestión de Bbdd MySql\n\nObjetivos:\n\n- Conectarse a Mysql.\n- Leer las bbdd existentes.\n- Selecionarlas  y leer sus tablas.\n- Seleccionar una tabla y leer los campos y los tipos de dato.\n- Realizar consultas. \n- Insertar registros.\n- Modificar valores.");
        jTextPane1.setDragEnabled(false);
        jTextPane1.setFocusable(false);
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 710, 190));

        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/azul.jpg"))); // NOI18N
        jLabelFondo.setText("GESTION DE BASES DE DATOS MYSQL");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 433));

        jMenu2.setText("Salir");
        jMenu2.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jLabelIconoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabelIconoMousePressed

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
            java.util.logging.Logger.getLogger(Acerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acerca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
