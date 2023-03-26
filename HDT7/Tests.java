import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {
    BiTree<Compare<String,String>> arbolPrueba = new BiTree<>();

    @Test
    public void insert() {
        arbolPrueba.insert(new Compare<String,String>("Prueba","Prueba"));
        assertEquals(true, arbolPrueba.contains(new Compare<>("Prueba")));
    }

    @Test
    public void get() {
        arbolPrueba.insert(new Compare<String,String>("Prueba","Prueba"));
        assertEquals(new Compare<>("Prueba","Prueba"), arbolPrueba.get(new Compare<String,String>("Prueba")));
    }
}
