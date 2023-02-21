import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {

    public static List<String> leerExpresionesDesdeArchivo(String archivo) throws IOException {
        List<String> expresiones = new ArrayList<>();
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            expresiones.add(linea);
        }
        lector.close();
        return expresiones;
    }
}