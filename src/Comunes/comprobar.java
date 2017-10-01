/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Comunes;

/**
 *
 * @author Javier Pelllicena Polo (c) Email: javipell@gmail.com 
 */
public class comprobar 
{

    public static boolean isNumerico (String cadena)
    {
        try 
        {
            Integer.parseInt(cadena);
            return true;
        } 
        catch (Exception ex) 
        {
            return false;
        }
    }
    public static boolean isDecimal (String cadena)
    {
        try 
        {
            Double.parseDouble(cadena);
            return true;
        } 
        catch (Exception ex) 
        {
            return false;
        }
    }
    
    /**
     * Metodo isFecha
     * 
     * comprueba si una cadena es una fecha valida
     * @param fecha tipo String
     * @return boolean
     */
    public static boolean isFecha(String fecha) 
    {
        try 
        {
            java.text.SimpleDateFormat formatoFecha;
            formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            System.out.println("fecha "+formatoFecha.parse(fecha));
            return true;
        } 
        catch (java.text.ParseException ex) 
        {
            System.out.println("fecha erronea "+ fecha);
            return false;
        }
    }
    
    public static void inFechaMySql(String fecha)
    {
        // para convertir una cadena de texto en fecha para mySql
        // SELECT  STR_TO_DATE(yourdatefield, '%m/%d/%Y') FROM  yourtable
        
    }
    
    /*
     * La siguiente función recibe dos parámetros de tipo String. 
     * La primer cadena es la cadena de la cual queremos remover cualquier 
     * caracter que se encuentre en la segunda cadena.
    */
    public static String EliminaCaracteres(String s_cadena, String s_caracteres)
    {
        String nueva_cadena = "";
        Character caracter = null;
        boolean valido = true;

        /* Va recorriendo la cadena s_cadena y copia a la cadena que va a regresar,
         * sólo los caracteres que no estén en la cadena s_caracteres 
         */
        for (int i = 0; i < s_cadena.length(); i++) 
        {
            valido = true;
            for (int j = 0; j < s_caracteres.length(); j++) 
            {
                caracter = s_caracteres.charAt(j);

                if (s_cadena.charAt(i) == caracter) 
                {
                    valido = false;
                    break;
                }
            }
            if (valido) 
            {
                nueva_cadena += s_cadena.charAt(i);
            }
        }

        return nueva_cadena;
    }

}
