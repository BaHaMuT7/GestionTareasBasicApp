package cl.bahamut.GestionTareas.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
	
    public static String MD5(String input) {
        try {
            String algoritmo = "MD5";
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            byte[] ab = md.digest(input.getBytes());
            BigInteger bi = new BigInteger(1, ab);
            String hash = bi.toString(16);

            while (hash.length() < 32) {
                hash = "0" + hash;
            }

            return hash;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String FECHA_TRANSFORMADA(String fecha) {

        String dia = fecha.substring(8, 10);
        String mes = fecha.substring(5, 7);
        String anio = fecha.substring(0, 4);
        String hora = fecha.substring(11);

        return dia + "-" + mes + "-" + anio + " " + hora;

    }
    

    public static String R_GEN ()
    {
        Random rnd = new Random();
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String cadena = "";
        int m, posicion, numero;
        m = 0;
        posicion = 0;
        while (m < 1)
        {
            posicion = (int) (rnd.nextDouble() * abc.length()-1+0);
            numero = (int) (rnd.nextDouble() * 9999 + 1000);
            cadena = cadena + abc.charAt(posicion)+numero;
            posicion = (int) (rnd.nextDouble() * abc.length()-1+0);   
            cadena = cadena + abc.charAt(posicion);   
            m++;
        }
        
        return cadena;
    }
}