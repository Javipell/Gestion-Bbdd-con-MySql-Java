
package Conexion;

import ClasesTablas.Persona; // SE PUEDE ELIMINAR SI NO SE UTILIZAN LOS METODOS registrarElena y javi
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase ConexionMySql
 * 
 * @author javier Pellicena 
 * email javipell@gmail.com
 */
public class ConexionMySql 
{
    
    private String Bbdd ; 
    private String url ; 
    private String login ; 
    private String password ; 
    
    private ArrayList nombreCampos = new ArrayList<>();
    private HashMap nombreCamposTipos = new HashMap<>();
    // no se detectan los nobres de variables utilizadas dentro de un try ???
    private ArrayList nombreTablas = new ArrayList<>();
    private ArrayList nombreBbdd = new ArrayList<>();
    private ArrayList nombreCatalogos = new ArrayList<>();
    
    private Connection conexion = null;
    
    /**
     * Metodo constructor 
     * este metodo busca las bases de datos mysql que hay en el equipo
     * y sus nombres los guarda en un arrayList llamado nombreCatalogos
     * @param user tipo string
     * @param pass tipo string
     */
    public ConexionMySql(String user, String pass)
    {
        String nombre ="";
        String url = "jdbc:mysql://localhost/";
        ResultSet resultado;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            try 
            {
                this.conexion = DriverManager.getConnection(url, user , pass );
                resultado = conexion.getMetaData().getCatalogs();
                while (resultado.next()) 
                {
                    nombre = resultado.getString("TABLE_CAT");

                    if ( !nombre.equals("information_schema") 
                            && !nombre.equals("performance_schema")
                            && !nombre.equals("mysql")
                            && !nombre.equals("sys")  )
                    {
                        System.out.println("Catalogos "+ nombre);
                        nombreCatalogos.add( nombre );
                    }
                }
            } 
            catch (SQLException ex) 
            {
                System.out.println("Error de Conexion en DriveManneger");
                Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Error en Class forName ");
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo constructor ConexionMySql
     * Recibe por parametros los valores de la conexion y la establece
     * @param base
     * @param usuario
     * @param pass 
     */
    public ConexionMySql( String base, String usuario, String pass)
    {
        Bbdd = base;
        login = usuario;
        password = pass;
        url = "jdbc:mysql://localhost/"+ this.Bbdd;

        try 
        {            
            // obtenemos el driver
            Class.forName("com.mysql.jdbc.Driver");
            // obtenemos conexion ...
            conexion = DriverManager.getConnection(url, login, password);
            // si la conexion tiene exito ...
            if (conexion != null)
            {
                System.out.println("Conexion a la BBDD: " + Bbdd + " correcta." );
                
                muestraObjetosBbdd();
            }
        } 
        catch (SQLException ex) 
        {
            /* se lanza cuando hay algún problema entre la base de datos y 
             * el programa Java JDBC.
            */
            System.out.println("Error SQLException: " 
                    + "\n Causa: "+ ex.getCause() 
                    + "\n Mensaje: " + ex.getMessage() 
                    + "\n SQLState: " + ex.getSQLState() );
        }
        catch (ClassNotFoundException ex)
        {
           /*
            * La definición de la clase no se encuentra debido a que la librería 
            * que lo contiene no esta en el classpath de la aplicación
            */
            System.out.println("Error ClassNotFoundException: " 
                    + "\n Causa: "+ ex.getCause() 
                    + "\n Mensaje: " + ex.getMessage() 
                    + "\n Datos: bbdd: " + this.Bbdd + " usuario " 
                    + this.login + " pass " + this.password);
        }
    }
    
    /**
     * Metodo modifcarRegistros
     * recibe una cadena sql con la consulta y la ejecuta
     * insert, update, delete
     * @param sql tipo String
     */
    public void modificaRegistros ( String sql)
    {
        Statement estado;

        try 
        {
            estado = this.getConexion().createStatement();
            // utlilizamos execute cuando devuelve varios resutaldos
            estado.executeUpdate(sql);
        }
        catch (SQLException ex) 
        {
            /* se lanza cuando hay algún problema entre la base de datos y 
             * el programa Java JDBC.
            */
            System.out.println("Error SQLException: " 
                    + "\n Causa: "+ ex.getCause() 
                    + "\n Mensaje: " + ex.getMessage() 
                    + "\n SQLState: " + ex.getSQLState() 
                    + "\n Codigo Error: " + ex.getErrorCode() );
        }
    }
    
    /**
     * Metodo compruebaDuplicado
     * comprueba si un registro ya existe en la tabla
     * @param sql tipo string, consulta sql
     * @return numeroResultados tipo int. valor de los registros encontrados
     */
    public int compruebaDuplicado ( String sql )
    {
        Statement estado;
        int numeroResultados = 0;
        try 
        {
            estado = this.getConexion().createStatement();
            ResultSet resultado = estado.executeQuery(sql);
            try 
            {
                resultado.last(); // va al ultimo registro
                numeroResultados = resultado.getRow();
                resultado.beforeFirst();
                System.out.println("numero  resultados "+ numeroResultados);
            } 
            catch (SQLException ex) 
            {
                System.out.println("Error en el conteo. \n" +ex.getMessage());
            }
        } 
        catch (Exception ex) 
        {
            System.out.println("Error en la consulta. \n" +ex.getMessage());
        }
        return numeroResultados;
    }
    
    /**
     * Metodo obtenerNombresColumnas
     * mediante DatabaseMetaData e indicandole el catalogo y la tabla
     * obtenemos los nombres de los campos y sus tipos de datos
     * los guardamos en un HashMap llamado nombreCamposTipo
     * 
     * Para cada tabla, obtener las columnas que la componen: su nombre y tipo. 
     * Para ello, podemos usar el método getColumns() de DataBaseMetaData.
     * ResultSet rs = metaDatos.getColumns(catalogo, null, tabla, null);
     * en el que los parámetros de la llamada son:
     *      El nombre del catálogo al que pertenece la tabla.
     *      El nombre del esquema, null para el esquema actual.
     *      El nombre de la tabla. Nuevamente podríamos poner comodines al 
     * estilo SQL para obtener, por ejemplo, las columnas de todas las 
     * tablas "person%" que empiecen por person.
     *      El nombre de las columnas buscadas, usando comodines. null nos 
     * devuelve todas las columnas.
     * 
     * El contenido del ResultSet será una fila por cada columna de la tabla. 
     * Las columnas del ResultSet se pueden ver en la API del método 
     * DataBaseMetaData.getColumns(). 
     * http://docs.oracle.com/javase/6/docs/api/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,%20java.lang.String,%20java.lang.String,%20java.lang.String)
     * En nuestro caso, si queremos el nombre 
     * de la columna y el nombre del tipo de dato de la columna, debemos hacer 
     * caso a las columnas 4 y 6 del ResultSet.
     * 
     * pongo dos ejemplos de como extraer los datos del HashMap
     * 
     * http://programandoointentandolo.com/2013/02/ejemplo-de-uso-de-hashmap-en-java-2.html
     * 
     */
    public void obtenerNombresColumnas( String catalogo, String tabla)
    {
        try 
        {
            // El contenido de cada columna del ResultSet se puede ver en
            // la API de java, en el metodo getColumns() de DataBaseMetaData
            DatabaseMetaData metaData = this.conexion.getMetaData();
            ResultSet resultado = metaData.getColumns(catalogo, null, tabla, null);
            
            while (resultado.next()) 
            {
                // La 4 corresponde al TABLE_NAME
                System.out.println("columna " + resultado.getString(4));
                // y la 6 al TYPE_NAME
                System.out.println("tipo " + resultado.getString(6));
                nombreCamposTipos.put(resultado.getString(4), resultado.getString(6) );
            }
            // 1a forma de recorrer el HashMap con un iterator
            String clave ;
            Iterator<String> campos = nombreCamposTipos.keySet().iterator();
            System.out.println("1a forma de recorrer el HashMap con un iterator");
            while (campos.hasNext()) 
            {
                clave = campos.next();
                System.out.println("nombres de campos "+ clave + " - " + nombreCamposTipos.get(clave));
            }
            // 2a forma de recorrer el HashMap
            Iterator iterador = nombreCamposTipos.entrySet().iterator();
            Map.Entry campos2;
            System.out.println("2a forma de recorrer el HashMap");
            while (iterador.hasNext()) 
            {
                campos2 = (Map.Entry) iterador.next();
                System.out.println("nombre de camopos: "+ campos2.getKey() + "-" + campos2.getValue());
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Metodo muestraTablas
     * Obtiene los nombres de las tablas de la base de datos
     * y los guarda en un ArrayList nombreTablas
     * @see http://www.chuidiang.org/java/mysql/ResultSet-DataBase-MetaData.php
     * 
     * donde los cuatro parámetros que hemos pasado son:
     * 1- catálogo de la base de datos. Al poner null, estamos preguntando por 
     * el catálogo actual, que en nuestro ejemplo es de la cadena de conexión, "hibernate".
     * 2- Esquema de la base de datos. Al poner null, es el actual.
     * 3- Patrón para las tablas en las que tenemos interés. En SQL el caracter 
     * que indica "todo" es %, equivalente al * a la hora de listar ficheros. 
     * Esto nos dará todas las tablas del catálogo y esquema actual. 
     * Podríamos poner cosas como "person%", con lo que obtendríamos todas las 
     * tablas cuyo nombre empiece por "person".
     * 4- El cuarto parámetro es un array de String, en el que pondríamos qué 
     * tipos de tablas queremos (normales, vistas, etc). Al poner null, nos 
     * devolverá todos los tipos de tablas.

     */
    public void muestraObjetosBbdd()
    {
        try 
        {
            DatabaseMetaData metaData = this.conexion.getMetaData();
            ResultSet resultado;
            // null = actual, % = todas
            resultado = metaData.getTables(null, null, "%" , null);
            System.out.println("Listado de objetos:");
            while (resultado.next()) 
            {
                // La columna 1 es TABLE_CAT
                System.out.println("Catalogo: " +resultado.getString(1)); 
                this.nombreBbdd.add( resultado.getString("TABLE_CAT"));
                
                // y la 2 es
                System.out.println("Tipo: "+ resultado.getString(2));
                
                // y la 3 es TABLE_NAME
                System.out.println("Tabla: "+ resultado.getString("TABLE_NAME"));
                this.nombreTablas.add( resultado.getString("TABLE_NAME"));
                
                obtieneNombresCampos(resultado.getString("TABLE_NAME"));
                
                obtenerNombresColumnas( resultado.getString(1), resultado.getString(3) );
                // quitar solo esta para pruebas
                obtieneNombreCamposDeConsulta ();
            }
            
        } 
        catch (SQLException ex) 
        {
            /* se lanza cuando hay algún problema entre la base de datos y 
             * el programa Java JDBC.
            */
            System.out.println("Error en el metodo muestraObjetosBbdd. "
                    + "\n Error SQLException: " 
                    + "\n Causa: "+ ex.getCause() 
                    + "\n Mensaje: " + ex.getMessage() 
                    + "\n SQLState: " + ex.getSQLState() );
        }
    }
    
    /**
     * Metodo obtieneNombresCampos
     * mediante la consulta sql "SHOW COLUMNS FROM persona"
     * obtenemos los nombres de los campos de la tabLa
     * @param tabla 
     */
    public void obtieneNombresCampos( String tabla)
    {
        String sqlCampos = "SHOW COLUMNS FROM " + tabla;
        
        Statement estado ;
        ResultSet resultado = null;
        
        try 
        {
            estado = this.getConexion().createStatement();
            // ejecutamos executeQuery cuando devuelve un solo resultado
            resultado = estado.executeQuery( sqlCampos );
            // recorremos el resultado mientras haya registros
            while (resultado.next() ) 
            {
                // añadimos al arrayList los nombres de los campos
                this.nombreCampos.add( resultado.getString("Field") );
                System.out.println("campo: "+resultado.getString("Field"));
            }
            // liberamos memoria
            resultado.close();
            estado.close();
        } 
        catch (SQLException ex) 
        {
            /* se lanza cuando hay algún problema entre la base de datos y 
             * el programa Java JDBC.
            */
            System.out.println("Error SQLException: " 
                    + "\n Causa: "+ ex.getCause() 
                    + "\n Mensaje: " + ex.getMessage() 
                    + "\n SQLState: " + ex.getSQLState() );
        }
    }
    
    /**
     * Metodo obtieneNombreCamposDeConsulta
     * 
     * Si no tenemos muy claro qué campos nos devuelve una consulta (quizás 
     * porque la consulta la ha escrito directamente el usuario desde una caja 
     * de texto), o queremos hacer algún trozo de código general capaz, por 
     * ejemplo, de meter cualquier ResultSet en un JTable,
     * http://www.chuidiang.org/java/mysql/resultset_jtable.php
     * nos puede resultar de utilidad la clase ResultSetMetaData.
     * 
     * @param sql tipo string
     */
    public void obtieneNombreCamposDeConsulta ()
    {
        String sql = "SELECT * FROM persona";
        try 
        {
            System.out.println("Metodo obtieneNombreCamposDeConsulta ");
            Statement estado = this.conexion.createStatement();
            ResultSet resultado = estado.executeQuery(sql);
            // A partir del ResultSet, podemos obtener el ResultSetMetaData, 
            // al que podremos interrogar sobre lo que queramos. 
            ResultSetMetaData rsmd = resultado.getMetaData();
            /* Vamos a preguntarle, primero, cuántas columnas tiene el ResultSet. 
             * Y luego, en un bucle, preguntaremos por el nombre de cada columna, 
             * a qué tabla pertenece y de qué tipo es. El bucle puede ser como este
             */
            Integer numColumnas = 0;
					  
            //número de columnas (campos) de la consula SQL            	  
            numColumnas = resultado.getMetaData().getColumnCount();
            System.out.println("llego "+ numColumnas);
            // el for debe empezar en uno 
            for (int i = 1; i <= numColumnas; i++) 
            {
                System.out.println("Tabla: " + rsmd.getTableName(i) 
                        + " Columna " + rsmd.getColumnName(i) 
                        + " Tipo " + rsmd.getColumnTypeName(i) );
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="ESTOS DOS METODOS SE PUEDEN ELIMINAR PARA NO TENER QUE UTILIZAR LA CLASE PERSONA">
    
    /***
     * Metodo registrarElena
     * *** mejor utilizar el metodo modificarRegistros
     * *** no necesita recibir datos sino solo el sql
     * @param datos tipo Persona
     */
    public void registrarElena ( Persona datos )
    {
        String sql = "";
        try 
        {
            Statement estado = this.getConexion().createStatement();
            sql = "INSERT INTO persona VALUES ( '"+ datos.getIdPersona() + "', '"
                    + datos.getNombrePersona() + "', '" + datos.getEdadPersona() + "', '"
                    + datos.getProfesionPersona() +"', '"+ datos.getTelefonoPersona() +"', "
                    + datos.getCasadoPersona() +" )";
            
            estado.executeUpdate( sql );
            JOptionPane.showMessageDialog(null, "Registro guardado con exito.", 
                    "Insercion", JOptionPane.INFORMATION_MESSAGE);
            estado.close();
            this.getDesconexion();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"No se ha podido guardar. \n" 
                    + ex.getMessage() + "\n SQL: " + sql, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /***
     * Metodo registroJavi 
     * *** mejor utilizar el metodo modificarRegistros
     * * *** no necesita recibir datos sino solo el sql
     * @param datos 
     */
    public void registroJavi( Persona datos)
    {
        String sql = "";
        
        try 
        {
            Connection estado = this.getConexion();
            PreparedStatement ps = null;
            sql = "INSERT INTO persona"
                + "(id, nombre, edad, profesion, telefono) VALUES"
                + "(?,?,?,?,?,?)";
            ps = estado.prepareStatement(sql);
            
            ps.setInt( 1, datos.getIdPersona() );
            ps.setString(2, datos.getNombrePersona() );
            ps.setInt(3, datos.getEdadPersona() );
            ps.setString(4, datos.getProfesionPersona() );
            ps.setString(5, datos.getTelefonoPersona() );
            ps.setBoolean(6, datos.getCasadoPersona() );
            ps.executeUpdate();
            
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"No se ha podido guardar. \n" 
                    + ex.getMessage() + "\n SQL: " + sql, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter and Getter">
    

    /**
     * @return the nombreCampos
     */
    public ArrayList getNombreCampos() 
    {
        return nombreCampos;
    }
    public ArrayList getNombreCatalogos()
    {
        return nombreCatalogos;
    }
    
    public ArrayList getNombreBbdd() 
    {
        return nombreBbdd;
    }

    public Connection getConexion() 
    {
        return conexion;
    }

    public void getDesconexion() 
    {
        this.conexion = null;
    }

    public String getBbdd() 
    {
        return Bbdd;
    }

    public void setBbdd(String Bbdd) 
    {
        this.Bbdd = Bbdd;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getLogin() 
    {
        return login;
    }

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    //</editor-fold>
}
