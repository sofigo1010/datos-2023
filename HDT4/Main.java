/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: Main.java
 * Fecha: 21/02/2023
 */

import java.io.IOException;

public class Main {
    public static  void main(String[] args){
        Controller controlador = new Controller();
        try {
            controlador.MenuCalculadora();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
}