import java.io.BufferedReader;
import java.io.FileReader;

public class Read {

    public static String leerTexto(String fileRoute){
        FileReader arr;
        BufferedReader reader;
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
}