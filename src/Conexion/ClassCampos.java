

package Conexion;

/**
 *
 * @author Javier Pelllicena Polo (c) Email: javipell@gmail.com 
 */
public class ClassCampos 
{
    int contador;
    String nombreCampo;
    String tipoCampo;
    String autoIncremento;
    int tamano;
    int decimales;
    int nulo;

    /**
     * Metodo Constructor <code>ClassCampos</code> 
     * 
     * sin parametros
     */
    public ClassCampos()
    {
        this.contador = 0;
        this.nombreCampo = "";
        this.tipoCampo = "";
        this.autoIncremento = "NO";
        this.tamano = 0 ;
        this.decimales = 0;
        this.nulo = 0;
    }
    
    /**
     * Metodo Constructor <code>ClassCampos</code>
     * 
     * @param contador tipo int
     * @param nombreCampo tipo String
     * @param tipoCampo tipo String
     * @param autoIncremento tipo String
     * @param tamano tipo int 
     * @param decimales tipo int
     * @param nulo  tipo int
     */
    public ClassCampos(int contador, String nombreCampo, String tipoCampo, 
            String autoIncremento, int tamano, int decimales, int nulo) 
    {
        this.contador = contador;
        this.nombreCampo = nombreCampo;
        this.tipoCampo = tipoCampo;
        this.autoIncremento = autoIncremento;
        this.tamano = tamano;
        this.decimales = decimales;
        this.nulo = nulo;
    }

    //<editor-fold defaultstate="collapsed" desc="SETTER AND GETTER">
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public String getAutoIncremento() {
        return autoIncremento;
    }

    public void setAutoIncremento(String autoIncremento) {
        this.autoIncremento = autoIncremento;
    }
    
    
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getDecimales() {
        return decimales;
    }

    public void setDecimales(int decimales) {
        this.decimales = decimales;
    }

    public int getNulo() {
        return nulo;
    }

    public void setNulo(int nulo) {
        this.nulo = nulo;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        return "ClassCampos{" + "contador=" + contador + ", nombreCampo=" + nombreCampo + ", tipoCampo=" + tipoCampo + '}';
    }
    
}
