import java.io.BufferedReader;
import java.io.FileReader;

public class Read {
    static FileReader arr;
    static BufferedReader reader;

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
