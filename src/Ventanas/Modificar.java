/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Conexion.ClassCampos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author javier
 */
public class Modificar extends javax.swing.JFrame {

    public String[][] valoresModificados ;
    
    /**
     * Creates new form Modificar
     */
    public Modificar() throws SQLException {
        initComponents();
        
        // centrar el formulario en la ventan
        this.setLocationRelativeTo(null);
        
        ponerCampos();
        
        //setJTexFieldChanged(jTextField1);
    }
    
    public void ponerCampos() throws SQLException
    {
        ClassCampos classCampos = new ClassCampos();
        ArrayList <ClassCampos> arrayCamposConexion = AccesoBbdd.conexion2.getaCCampos();
        ResultSet datos = Principal.listaDatos;
        valoresModificados = new String[4][ arrayCamposConexion.size() ];    
        int fila = Principal.filaDatos;
        //<editor-fold defaultstate="collapsed" desc="Cabezera de la tabla">
        
        JLabel etiqueta0 = new JLabel();
        etiqueta0.setText( "CAMPO" );
        etiqueta0.setFont(new java.awt.Font("Lucida Grande", 1, 14));

        JLabel etiqueta1 = new JLabel();
        etiqueta1.setText("TIPO" );
        etiqueta1.setFont(new java.awt.Font("Lucida Grande", 1, 14));

        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("VALOR" );
        etiqueta2.setFont(new java.awt.Font("Lucida Grande", 1, 14));

        jPanel1.add(etiqueta0);
        jPanel1.add(etiqueta1);
        jPanel1.add(etiqueta2);
        //</editor-fold>
        
        for (int i = 0; i < arrayCamposConexion.size(); i++) 
        {
            classCampos = arrayCamposConexion.get(i);
            JLabel etiqueta3 = new JLabel();
            etiqueta3.setText( classCampos.getNombreCampo() );
            etiqueta3.setFont(new java.awt.Font("Lucida Grande", 1, 16));

            JLabel etiqueta4 = new JLabel();
            etiqueta4.setText("(" + classCampos.getTipoCampo() +")" );
            etiqueta4.setFont(new java.awt.Font("Lucida Grande", 1, 12));
            
            //JTextArea texto1 = new JTextArea();
            JTextField texto1 = new JTextField( classCampos.getNombreCampo() );
            String valor = "";
            int x = 0;
            datos.beforeFirst(); // vuelve al primero
            // recorre los registros devueltos por la consulta
            while (datos.next())
            {
                // cuando la posicion del registros es igual a la fila que
                // queremos modificar guarda en un array el nombre del campo 
                // y el valor devuelto por la consulta
                if (x==fila) 
                {
                    valor = String.valueOf( datos.getString(i+1) ) ;
                    valoresModificados[0][i] = String.valueOf( i ); // posicion
                    valoresModificados[1][i] = classCampos.getNombreCampo() ; // nombre
                    valoresModificados[2][i] = valor; // valor
                    valoresModificados[3][i] = valor; // copia del valor
                }
                x++;
            }
            // devuelve el puntero a la primera posicion de los resultados devueltos
            // para poder volver a buscar
            datos.beforeFirst(); 
            // al nuevo JTextField el poner como valor el devuelto por la consulta
            texto1.setText( valor );
            // cambio la fuente y el tamaño
            texto1.setFont(new java.awt.Font("Lucida Grande", 1, 14));
            // cambio el nombre del campo por el nombre de la columna de la consulta
            texto1.setName( classCampos.getNombreCampo() ) ;
            // añado un evento para cuando el usuario cambie el valor devuelto por la consulta
            texto1.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    texto1ActionPerformed(evt);
                }
                private void texto1ActionPerformed(java.awt.event.ActionEvent evt) 
                {
                    // recorro el array de los valores que quiero modificar
                    for (int j = 0; j < valoresModificados[0].length; j++) 
                    {
                        // busco en el array el campo que quiero modificar 
                        if (texto1.getName().equals( valoresModificados[1][j]))
                        {
                            System.out.println("logitud "+valoresModificados[0].length
                                + " campo "+ valoresModificados[0][j] 
                                + " " + valoresModificados[1][j] 
                                + " " + valoresModificados[2][j]);
                            // si el valor original ha cambiado ...
                            if (!texto1.getText().equals(valoresModificados[2][j]))
                            {
                                // actualizo el array con el nuevo valor
                                valoresModificados[2][j] = texto1.getText();
                                System.out.println("logitud "+valoresModificados[0].length
                                + " campo "+ valoresModificados[0][j] 
                                + " " + valoresModificados[1][j] 
                                + " " + valoresModificados[2][j]);
                            }
                        }
                    }
                }
            });
            
            jPanel1.add(etiqueta3);
            jPanel1.add(etiqueta4);
            jPanel1.add(texto1);
            
        }
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCancelar = new javax.swing.JMenuItem();
        jMenuGuardar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 153));
        setUndecorated(true);

        jPanel1.setLayout(new java.awt.GridLayout(0, 3));
        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        jLabel1.setText("MODIFICACION DE DATOS ");

        jLabel2.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        jLabel2.setText("PARA GUARDAR : MENU CAMBIOS - GUARDAR");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("<html>Pulse INTRO cada vez <br>que realice un cambio </html>");

        jMenu1.setText("Cambios");

        jMenuCancelar.setText("Cancelar");
        jMenu1.add(jMenuCancelar);

        jMenuGuardar.setText("Guardar");
        jMenuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    
    private void jMenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarActionPerformed
        // TODO add your handling code here:
        String sql = "UPDATE "+ Principal.tablaSeleccionada +" SET ";
        // TELEFONO='111', NOMBRE='ASDFASD', EDAD='21' WHERE ID='25';";
        
        for (int i = 0; i <= valoresModificados.length+1; i++) 
        {
            sql += valoresModificados[1][i] +"='" + valoresModificados[2][i];
            System.out.println("sql1 "+sql);
            if ( i <= (valoresModificados.length ) ) 
            { 
                sql += "', ";
            }
            else
            {
                sql += "' ";
            }
        }
        sql += " WHERE " + valoresModificados[1][0] + "=" + valoresModificados[3][0] + " ;";
        System.out.println("sql: " + sql);
        AccesoBbdd.conexion2.modificaRegistros(sql);
        JOptionPane.showMessageDialog(null, "El registro ha sido actualizado."
                ,"Actualizdo",JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(false);
    }//GEN-LAST:event_jMenuGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Modificar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCancelar;
    private javax.swing.JMenuItem jMenuGuardar;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
