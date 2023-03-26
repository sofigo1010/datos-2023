import java.io.BufferedReader;
import java.io.FileReader;

public class Read {

    /**
    Lee un archivo de texto y devuelve su contenido en formato de String.
    @param archivo la ruta del archivo a leer.
    @return una cadena de caracteres que representa el contenido del archivo.
    @throws RuntimeException si la dirección del archivo es inválida o no se puede leer.
    */
    public static String leerTexto(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            StringBuilder texto = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                texto.append(line);
            }
            return texto.toString();
        } catch (Exception e) {
            throw new RuntimeException("Direccion invalida: " + e.getMessage());
        }
    }
}