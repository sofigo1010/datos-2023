import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Read.java
 * Fecha: 21/04/2023
 */

public class Read {
    static FileReader arr;
    static BufferedReader reader;

   /**
     * Lee un archivo de texto y retorna su contenido en forma de cadena de caracteres.
     *
     * @param fileRoute la ruta del archivo de texto a leer.
     * @return el contenido del archivo de texto en forma de cadena de caracteres.
     * @throws RuntimeException si la ruta del archivo no existe o si ocurre un error inesperado.
     */
    public static String leerTexto(String fileRoute){
        try {
            arr = new FileReader(fileRoute);
            if (arr.ready()) {
                reader = new BufferedReader(arr); 
                String line;
                String mensajeParaRetornar = "";
                while ((line = reader.readLine()) != null) {
                    mensajeParaRetornar+=line;
                }
                return mensajeParaRetornar;
            } else {
                throw new RuntimeException("File route doesn't exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Error: "+e);
        }
    }

    /**
     * Crea un árbol de búsqueda binaria a partir de un archivo de texto 
     *
     * @param fileRoute la ruta del archivo de texto a leer.
     * @param arbolT el árbol de búsqueda a construir.
     * @return el árbol de búsqueda construido a partir del archivo de texto.
     * @throws RuntimeException si la ruta del archivo no existe o si ocurre un error inesperado.
     */
    public static Tree<String,String> crearArbolTraduccion(String fileRoute, Tree<String,String> arbolT){
        try {
            arr = new FileReader(fileRoute);
            if (arr.ready()) {
                reader = new BufferedReader(arr); // read the file
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] palabras = line.split(",");
                    arbolT.insert(palabras[1].toLowerCase(), palabras[0].toLowerCase());
                }
                return arbolT;
            } else {
                throw new RuntimeException("File route doesn't exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Error: "+e);
        }
    }
}
