

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

    public ClassCampos()
    {
        this.contador = 0;
        this.nombreCampo = "";
        this.tipoCampo = "";
    }
    public ClassCampos(int contador, String nombreCampo, String tipoCampo) 
    {
        this.contador = contador;
        this.nombreCampo = nombreCampo;
        this.tipoCampo = tipoCampo;
    }

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

    @Override
    public String toString() {
        return "ClassCampos{" + "contador=" + contador + ", nombreCampo=" + nombreCampo + ", tipoCampo=" + tipoCampo + '}';
    }
    
}
