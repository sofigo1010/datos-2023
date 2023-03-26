/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Words.java
 * Fecha: 25/03/2023
 */

public class Words<V,K> {
    public V key;
    public K value;

    /**
     * Obtiene el valor asociado con esta instancia de Words.
     * @return El valor asociado.
     */
    public K getValue() {
        return value;
    }

    /**
     * Establece el valor asociado con esta instancia de Words.
     * @param value El valor a establecer.
     */
    public void setValue(K value) {
        this.value = value;
    }

    /**
     * Crea una nueva instancia de Words con la llave y el valor dados.
     * @param KEY La llave a almacenar.
     * @param VALUE El valor a almacenar.
     */
    public Words(V KEY, K VALUE) {
        key = KEY;
        value = VALUE;
    }
    
    /**
     * Establece la llave asociada con esta instancia de Words.
     * @param key La llave a establecer.
     */
    public void setKey(V key) {
        this.key = key; 
    }

    /**
     * Obtiene la llave asociada con esta instancia de Words.
     * @return La llave asociada.
     */
    public V getKey() {
        return key;
    }

    /**
     * Compara si otro objeto es igual a esta instancia de Words.
     * @param other El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Words otherAssoc = (Words) other;
        return getKey().equals(otherAssoc.getKey());
    }

 
}
