/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author javier
 */
public class Tablas extends javax.swing.JFrame 
{
    
    // crear componentes en modo ejecucion de forma dinamica
    // tutorial https://www.youtube.com/watch?v=bp9XblpZSSw&t=335s
    // creamos una lista de JRadioButton 
    // importamos java.util.List javax.swing.JRadioButton
    //
    private List<JRadioButton> tablas;
    // se añadira al final del nombre del radiobuton para diferenciarlos    
    
    /**
     * Creates new form Tablas
     */
    public Tablas() {
        initComponents();
        // centrar el formulario en la ventan
        this.setLocationRelativeTo(null);
        tablas = new ArrayList(AccesoBbdd.conexion2.getNombreTablas());
        
        System.out.println("numero tablas " + tablas.size());
        for (int i = 0; i < tablas.size(); i++) 
        {
            System.out.println("nombre tabla "+ tablas.get(i));
            JRadioButton boton = new JRadioButton(String.valueOf( tablas.get(i) ) );
            
            boton.setActionCommand( boton.getName() );
            boton.setFont(new java.awt.Font("Lucida Grande", 1, 16));
            boton.setForeground(new java.awt.Color(255, 255, 255));


            //<editor-fold defaultstate="collapsed" desc="Instrucciones de implementacion">
            /* 
             * Para añadir un evento al nuevo boton
             *
             * El codigo a poner es:
             *
             *  boton.addActionListener(new ActionListener(){
             *      @Override
             *      public void actionPerformed(ActionEvent e)
             *      {
             *          System.out.println("boton presionado");
             *      }
             *  });
             *
             * Cuando muestre el error subrayando todo en rojo
             * pulsar sobre la primera bombilla con el boton rojo y 
             * seleccionar Impementar todos los metodos abstractos
             *
             * el importara :
             * y añadira el siguiente codigo que tendremos que eliminar
             *
             *  @Override
             *  public void actionPerformed(ActionEvent e) {
             *       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             *   }
             * ***************************************************
             * OTRA FORMA MAS SENCILLA : PEGAR EL SIGUIENTE CODIGO
             * ***************************************************
             *
             * boton.addActionListener(new java.awt.event.ActionListener() 
             * {
             *    public void actionPerformed(java.awt.event.ActionEvent evt) 
             *    {
             *      // LA SIGUIENTE INSTRUCCION ES EL EVENTO
             *      // COMO ASIGNARLE UN NOMBRE DIFERENTE A CADA EVENTO ???
             *      //SalirActionPerformed(evt);
             *      JOptionPane.showMessageDialog(null, "Ha seleccionado la tabla: "
             *              , "Seleccion realizada", HEIGHT);
             *    }
             * });
             *
            */
            //</editor-fold>

            boton.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    /*
                    JOptionPane.showMessageDialog(null, "Ha seleccionado la tabla: " 
                            + boton.getText()
                            , "Seleccion realizada", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("evento seleccinado " + evt.getActionCommand());
                    */
                    Principal.tablaSeleccionada= evt.getActionCommand();
                    
                }
            });
            
            // añado el nuevo boton a buttonGroup para que solo se pueda seleccionar uno
            buttonGroupTablas.add(boton);
            // añado el boton al panel
            jPanel1.add(boton);
        }
        // actualizo el panel para que se vea el nuevo boton
        jPanel1.updateUI();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTablas = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 315, 232));

        jLabel2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione la tabla con la que desee trabajar");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnSalir.setBackground(new java.awt.Color(0, 0, 153));
        btnSalir.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("VOLVER");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/azul.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        System.out.println("tabla seleccionada antes salir "+Principal.tablaSeleccionada);
        if ( !Principal.tablaSeleccionada.equals("") ) 
        {
            // oculta la ventana
            //this.setVisible(false);
            // cierra la ventana
            this.dispose();
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tabla.");
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroupTablas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
