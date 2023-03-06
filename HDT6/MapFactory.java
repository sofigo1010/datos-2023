/**
 * @author Sofia Garcia
 * Folder: HDT6
 * Archivo: MapFactory.java
 * Fecha: 05/03/2023
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {

    public static Map<Integer, Producto> crearmapa (int type){
        if (type == 1){
            return new HashMap<Integer, Producto>();
        }
        else if (type == 2){
            return new TreeMap<Integer, Producto>();
        }
        else if (type ==3){
            return new LinkedHashMap<Integer, Producto>();
        }
        else{
            throw new IllegalArgumentException("Tipo invalido, intente de nuevo.");
        }
    }
    
}
