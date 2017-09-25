/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ClasesTablas.Persona;
import Conexion.ConexionMySql;
import ListaArray.ListaPersona;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author javier
 */
public class Principal extends javax.swing.JFrame {

    public ConexionMySql conexion;
    public static String tablaSeleccionada = "";

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        // centra el formulario en la pantalla
        this.setLocationRelativeTo(this);
        jPanel1.setVisible(false);
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
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtBase = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuAbrirBbdd = new javax.swing.JMenuItem();
        jMenuAccesoBbdd = new javax.swing.JMenuItem();
        jMenuGestion = new javax.swing.JMenu();
        jMenuTablas = new javax.swing.JMenuItem();
        jMenuItemListado = new javax.swing.JMenuItem();
        jMenuBuscar = new javax.swing.JMenuItem();
        jMenuAñadirRegistro = new javax.swing.JMenuItem();
        jMenuAñadirRegistro2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemListadoId = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de la Busqueda"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 640, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 640, 380));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/azul.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 460));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));
        getContentPane().add(txtBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 100, -1));
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, -1));

        jMenuBar1.setForeground(new java.awt.Color(0, 0, 204));

        menuArchivo.setText("Archivo");

        menuAbrirBbdd.setText("Buscar Archivos");
        menuAbrirBbdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirBbddActionPerformed(evt);
            }
        });
        menuArchivo.add(menuAbrirBbdd);

        jMenuAccesoBbdd.setText("Acceso BBDD");
        jMenuAccesoBbdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAccesoBbddActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuAccesoBbdd);

        jMenuBar1.add(menuArchivo);

        jMenuGestion.setText("Gestion");

        jMenuTablas.setText("Seleccionar Tabla");
        jMenuTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTablasActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuTablas);

        jMenuItemListado.setLabel("Listado Completo");
        jMenuItemListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuItemListado);

        jMenuBuscar.setText("Buscar");
        jMenuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBuscarActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuBuscar);

        jMenuAñadirRegistro.setText("Añadir Registro");
        jMenuAñadirRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAñadirRegistroActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuAñadirRegistro);

        jMenuAñadirRegistro2.setText("Añadir Registro2");
        jMenuAñadirRegistro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAñadirRegistro2ActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuAñadirRegistro2);
        jMenuGestion.add(jSeparator1);

        jMenuItemListadoId.setText("Listado por  Id");
        jMenuItemListadoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoIdActionPerformed(evt);
            }
        });
        jMenuGestion.add(jMenuItemListadoId);

        jMenuBar1.add(jMenuGestion);

        menuSalir.setText("Salir");

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        menuSalir.add(jMenuSalir);

        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo menuAbrirBbddActionPerformed Abre un explorador de archivos y
     * guarda la ruta y el nombre del archivo seleccionado
     *
     * @param evt
     */

    private void menuAbrirBbddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirBbddActionPerformed

        // miFichero.EjemploJFileChooser(); 
        JFileChooser jf = new JFileChooser();
        int opcion = jf.showOpenDialog(this);
        // para crear filtros de archivos
        FileNameExtensionFilter fitroArchivos = new FileNameExtensionFilter("Archivos BBDD", "mdb");
        jf.setFileFilter(fitroArchivos);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            // obtener el nombre del archivo
            String nombreArchivo = jf.getSelectedFile().getName();
            String rutaArchivo = jf.getSelectedFile().toString();
            System.out.println("ruta archivo " + rutaArchivo);
            System.out.println("nombre archivo " + nombreArchivo);
        }

    }//GEN-LAST:event_menuAbrirBbddActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuAccesoBbddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAccesoBbddActionPerformed
        AccesoBbdd frmAcceso = new AccesoBbdd();
        frmAcceso.setVisible(true);
    }//GEN-LAST:event_jMenuAccesoBbddActionPerformed

    private void jMenuItemListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoActionPerformed

        
        String sql = "SELECT * FROM " + tablaSeleccionada;
        listaDatos(sql);
    }//GEN-LAST:event_jMenuItemListadoActionPerformed
    
    /**
     * Metodo jMenuItemListadoIdActionPerformed
     * ** obsoleto utilizar el metodo jMenuBuscarActionPerformed
     * @param evt 
     */
    private void jMenuItemListadoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoIdActionPerformed

        ListaPersona lista = new ListaPersona();
        Persona p = new Persona();
        int id = 0;
        String respuesta = JOptionPane.showInputDialog(null,
                "Introduzca el Identificador que desea buscar \n");
        codigo:
        {
            if (respuesta.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe introducir un numero",
                        "Valor incorrecto", JOptionPane.ERROR_MESSAGE);
                break codigo;
            }

            try {
                id = Integer.parseInt(respuesta);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debe introducir un numero",
                        "Valor incorrecto", JOptionPane.ERROR_MESSAGE);
                break codigo;
            }

            ArrayList<Persona> listaPersona = lista.listadoRegistro(id);
            int numeroRegistros = listaPersona.size();
            jPanel1.setVisible(true);
            // creamos un objeto para guardar los nombres de las columnas
            Object[] columnas = {"IdPersona", "Nombre", "Edad", "Profesion", "Telefono"};
            // creamos un objeto array bidimensional para guardar los registro
            Object[][] filas = new Object[numeroRegistros][columnas.length];

            if (listaPersona.size() > 0) {
                for (int i = 0; i < listaPersona.size(); i++) {
                    p = listaPersona.get(i);
                    filas[i][0] = p.getIdPersona();
                    filas[i][1] = p.getNombrePersona();
                    filas[i][2] = p.getEdadPersona();
                    filas[i][3] = p.getProfesionPersona();
                    filas[i][4] = p.getTelefonoPersona();
                }
                JTable table = new JTable(filas, columnas);
                jScrollPane1.setViewportView(table);
            } else {
                JOptionPane.showMessageDialog(null, "Actualmente no existen registros de personas",
                        "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                jPanel1.setVisible(true);
            }

        }
    }//GEN-LAST:event_jMenuItemListadoIdActionPerformed

    private void jMenuAñadirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAñadirRegistroActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        if (creaConexion() == true) {
            Persona p = new Persona();
            ListaPersona lista = new ListaPersona();

            String mensaje = "Introduce \n\n";
            //String[] datosSolicitados = {"Identificador", "Nombre", "Edad", "Profesion", "Telefono"};
            ArrayList datosSolicitados = conexion.getNombreCampos();
            String[] datosRecogidos = new String[ datosSolicitados.size() ];

            for (int i = 0; i < datosSolicitados.size(); i++) 
            {
                datosRecogidos[i] = JOptionPane.showInputDialog(null,
                        (mensaje + datosSolicitados.get(i)) + " : \n");
            }

            int b = 0;
            p.setIdPersona(Integer.parseInt( datosRecogidos[b++] ) );
            p.setNombrePersona( datosRecogidos[b++] );
            p.setEdadPersona(Integer.parseInt( datosRecogidos[b++] ) );
            p.setProfesionPersona( datosRecogidos[b++] );
            p.setTelefonoPersona( datosRecogidos[b++] );
            p.setCasadoPersona(Boolean.valueOf( datosRecogidos[b++] ) );

            conexion.registrarElena(p);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la conexion");
        }

    }//GEN-LAST:event_jMenuAñadirRegistroActionPerformed

    private void jMenuAñadirRegistro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAñadirRegistro2ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        if (creaConexion() == true) {
            Persona p = new Persona();
            ListaPersona lista = new ListaPersona();

            String mensaje = "Introduce \n\n";
            //String[] datosSolicitados = {"Identificador", "Nombre", "Edad", "Profesion", "Telefono"};
            
            ArrayList datosSolicitados = conexion.getNombreCampos();
            
            String[] datosRecogidos = new String[ datosSolicitados.size() ];

            for (int i = 0; i < datosSolicitados.size(); i++) {
                datosRecogidos[i] = JOptionPane.showInputDialog(null,
                        (mensaje + datosSolicitados.get(i))  + " : \n");
            }

            int b = 0;
            p.setIdPersona(Integer.parseInt(datosRecogidos[b++]));
            p.setNombrePersona(datosRecogidos[b++]);
            p.setEdadPersona(Integer.parseInt(datosRecogidos[b++]));
            p.setProfesionPersona(datosRecogidos[b++]);
            p.setTelefonoPersona(datosRecogidos[b++]);
            p.setCasadoPersona(Boolean.valueOf( datosRecogidos[b++] ) );

            String sql = "INSERT INTO persona VALUES ( '" + p.getIdPersona()
                    + "', '" + p.getNombrePersona()
                    + "', '" + p.getEdadPersona()
                    + "', '" + p.getProfesionPersona()
                    + "', '" + p.getTelefonoPersona() 
                    + "', " + p.getCasadoPersona()
                    + " )";
            System.out.println("sql "+sql);

            conexion.modificaRegistros(sql);

        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la conexion");
        }
    }//GEN-LAST:event_jMenuAñadirRegistro2ActionPerformed

    private void jMenuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBuscarActionPerformed

        jPanel1.setVisible(false);
        String sql ="";
        int seleccion =0 ;
        String cadena = "Seleccione el dato que desea buscar \n";
        //String[] datosSolicitados = {"Id", "Nombre", "Edad", "Profesion", "Telefono"};


        String respuesta ="";
        
        if (creaConexion() == true) 
        {
            // guardo en un arralist los nombres de los campos de la tabla
            ArrayList datosSolicitados = conexion.getNombreCampos() ;

            for (int i = 0; i < datosSolicitados.size(); i++) {
                cadena += "\n " + (i + 1) + ".- " + datosSolicitados.get(i);
            }
            respuesta = JOptionPane.showInputDialog(null, cadena, "Seleccione una opcion", 
                    JOptionPane.OK_CANCEL_OPTION);
            codigo:
            {
                if (respuesta == null) 
                {
                    mensajeError();
                    break codigo;
                } 
                else 
                {
                    try
                    {
                    seleccion = Integer.parseInt(respuesta) - 1;
                    if (seleccion < 0 || seleccion > datosSolicitados.size()) 
                    {
                        mensajeError();
                        break codigo;
                    }
                    cadena = "Introduzca el dato \n"
                            + datosSolicitados.get(seleccion);
                    respuesta = JOptionPane.showInputDialog(null, cadena);
                    }
                    catch (Exception Ex)
                    {
                        mensajeError();
                    }
                    
                    sql = "SELECT * FROM " + tablaSeleccionada + " WHERE "
                            + datosSolicitados.get(seleccion) + " LIKE '%" + respuesta + "%' ";
                    
                    listaDatos(sql);
                }
            }
        }
    }//GEN-LAST:event_jMenuBuscarActionPerformed

    private void jMenuTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTablasActionPerformed
        // TODO add your handling code here:
        
        if ( creaConexion() )
        {
            Tablas frmTablas = new Tablas();
            frmTablas.setVisible(true);
        }
    }//GEN-LAST:event_jMenuTablasActionPerformed

    public void listaDatos(String sql)
    {
        if (creaConexion() == true) 
        {
            conexion.obtieneNombresCampos( tablaSeleccionada );
            ListaPersona lista = new ListaPersona();
            Persona p = new Persona();
            System.out.println("sql " + sql);
            ArrayList<Persona> listaPersona = lista.listadoTodosRegistros(sql);
            int numeroRegistros = listaPersona.size();

            jPanel1.setVisible(true);
            // guardo en un arralist los nombres de los campos de la tabla
            ArrayList datosSolicitados = conexion.getNombreCampos() ;
            // creamos un objeto para guardar los nombres de las columnas
            //Object[] columnas = {"IdPersona", "Nombre", "Edad", "Profesion", "Telefono"};
            Object[] columnas = new Object[datosSolicitados.size()];
            for (int i = 0; i < datosSolicitados.size(); i++) 
            {
                columnas[i] = datosSolicitados.get(i);
            }
            
            // creamos un objeto array bidimensional para guardar los registro
            Object[][] filas = new Object[numeroRegistros][columnas.length];
            //
            // OBJETIVO CAMBIAR ESTE SISTEMA POR OTRO QUE SIRVA PARA CUALQUIER TABLA
            //

            if (listaPersona.size() > 0) {
                for (int i = 0; i < listaPersona.size(); i++) {
                    p = listaPersona.get(i);
                    filas[i][0] = p.getIdPersona();
                    filas[i][1] = p.getNombrePersona();
                    filas[i][2] = p.getEdadPersona();
                    filas[i][3] = p.getProfesionPersona();
                    filas[i][4] = p.getTelefonoPersona();
                }
                JTable table = new JTable(filas, columnas);
                jScrollPane1.setViewportView(table);
            } else {
                JOptionPane.showMessageDialog(null, "Actualmente no existen registros" 
                        + "\nTabla seleccionada: " + tablaSeleccionada,
                        "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                jPanel1.setVisible(false);
            }
        }
    }
    
    public void mensajeError()
    {
        JOptionPane.showMessageDialog(null, "Introduzca el dato solicitado.", 
                "Datos Erroneos", JOptionPane.ERROR_MESSAGE);
    }
    
    
    public Boolean creaConexion()
    {
        Boolean respuesta = false;

        if (!AccesoBbdd.txtBaseDatos.getText().equals("") 
                && !AccesoBbdd.txtUsuario.getText().equals("")
                && !String.valueOf( AccesoBbdd.txtContraseña.getPassword() ).equals("") ) 
        {
            // creo una conexion con los valores ocultos del formulario principal
            conexion = new ConexionMySql(AccesoBbdd.txtBaseDatos.getText(),
                    AccesoBbdd.txtUsuario.getText(), 
                    String.valueOf( AccesoBbdd.txtContraseña.getPassword() ) );
            int valor = conexion.getNombreTablas().size();
            if (valor>0)
            {
                if (tablaSeleccionada!="")
                {
                    respuesta = true;
                } 
                else
                {
                    Tablas frmTablas = new Tablas();
                    frmTablas.setVisible(true);
                }
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No hay tablas en esta base de datos");
            }
        }
        return respuesta;
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAccesoBbdd;
    private javax.swing.JMenuItem jMenuAñadirRegistro;
    private javax.swing.JMenuItem jMenuAñadirRegistro2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuBuscar;
    private javax.swing.JMenu jMenuGestion;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemListado;
    private javax.swing.JMenuItem jMenuItemListadoId;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuTablas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menuAbrirBbdd;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuSalir;
    public static javax.swing.JTextField txtBase;
    public static javax.swing.JTextField txtContraseña;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
