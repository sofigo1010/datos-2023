/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: Read.java
 * Fecha: 21/02/2023
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Read {
  private ArrayList<ArrayList<String>> funciones;
  
  /** Funcion que lee el archivo con las ecuaciones y las vuelve una cadena y las agrega a una arraylist
   * @param filename
   * @return ArrayList<ArrayList<String>>
   */
  public ArrayList<ArrayList<String>> leerExpresiones(String filename) {
    funciones = new ArrayList<ArrayList<String>>();
    Path filePath = Paths.get(filename);

    try {
        BufferedReader buffer = Files.newBufferedReader(filePath);
        String line;
        while ((line = buffer.readLine()) != null) {
            String[] linefuncion = line.split("");
            ArrayList<String> fila = new ArrayList<String>();
            for (String item : linefuncion) {
                fila.add(item);
            }

            funciones.add(fila);
        }
    } catch (IOException exception) {
        exception.printStackTrace();
    }

    return funciones;
}
}