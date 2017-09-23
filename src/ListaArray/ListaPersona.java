
package ListaArray;

import ClasesTablas.Persona;
import Ventanas.AccesoBbdd;

import java.util.ArrayList;
import Conexion.ConexionMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 * Clase ListaPersona
 * guarda en una ArrayList de Persona los datos solicitados de la tabla
 * @author javier Pellicena
 */
public class ListaPersona 
{
    public ConexionMySql conexion ;
    public AccesoBbdd acceso;
    
    /**
     * Metodo listadoTodosRegistros
     * busca todos los registros de una tabla
     * @param sql tipo string
     * @return empleado tipo ArrayList
     */
    public ArrayList<Persona> listadoTodosRegistros(String sql)
    {
        // creo una conexion con los valores ocultos del formulario AccesoBbdd
        conexion = new ConexionMySql( AccesoBbdd.txtBaseDatos.getText() , 
                 AccesoBbdd.txtUsuario.getText(), 
                String.valueOf( AccesoBbdd.txtContraseña.getPassword() ) );
        // creo un arrayLista con la clase persona
        ArrayList<Persona> empleado = new ArrayList<Persona>();
        //String sql = "SELECT * FROM persona";
        try 
        {
            // preparo la consulta
            PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            // ejecuto la consulta y la guardo en la varible resultado
            ResultSet resultado = consulta.executeQuery();
            // recorro los registros de resultado
            while (resultado.next()) 
            {
                // creo una instancia de la clase persona
                Persona p = new Persona();
                // guardo los campos del registro en la calse persona
                p.setIdPersona( Integer.parseInt( resultado.getString(1) ) );
                p.setNombrePersona( resultado.getString(2) );
                p.setEdadPersona( Integer.parseInt( resultado.getString(3) ) );
                p.setProfesionPersona( resultado.getString(4) );
                p.setTelefonoPersona( resultado.getString(5) );
                
                empleado.add(p);
            }
            
            // liberamos memoria
            resultado.close();
            consulta.close();
            conexion.getDesconexion(); 
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo entrontrar el registro.", 
                    "Error en la Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return empleado;
    }
    
    public ArrayList<Persona> listadoRegistro(int valor)
    {
        // creo una conexion con los valores ocultos del formulario AccesoBbdd
        conexion = new ConexionMySql( AccesoBbdd.txtBaseDatos.getText() , 
                 AccesoBbdd.txtUsuario.getText(), 
                String.valueOf( AccesoBbdd.txtContraseña.getPassword() ) );
        
        ArrayList<Persona> empleado = new ArrayList<Persona>();
        String sql = "SELECT * FROM persona WHERE id=?";
        try 
        {
            PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            consulta.setInt(1, valor);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) 
            {
                Persona p = new Persona();
                p.setIdPersona( Integer.parseInt( resultado.getString(1) ) );
                p.setNombrePersona( resultado.getString(2) );
                p.setEdadPersona( Integer.parseInt( resultado.getString(3) ) );
                p.setProfesionPersona( resultado.getString(4) );
                p.setTelefonoPersona( resultado.getString(5) );
                
                empleado.add(p);
            }
            // liberamos memoria
            resultado.close();
            consulta.close();
            conexion.getDesconexion();
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo entrontrar el registro.", 
                    "Error en la Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return empleado;
    }
    
    
}
