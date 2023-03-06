/**
 * @author Sofia Garcia
 * Folder: HDT6
 * Archivo: Read.java
 * Fecha: 05/03/2023
 */

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Read {

    public void getinventory(Map <Integer, Producto> productoTree, String filename) {
        try {
               Scanner input = new Scanner(new File(filename));
               int i = 1;
               while (input.hasNextLine()) {
                   String line = input.nextLine();
                   String[] tokens = line.split(" \\|	");
                   productoTree.put(i, new Producto(tokens[1], tokens[0], 10));
                   i++;
               }
               input.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           }
   }
}
