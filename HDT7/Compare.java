/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Compare.java
 * Fecha: 25/03/2023
 */

/**
 *
 * Tomado de referencia del libro Java Structure 
 * @param <K>
 * @param <V>
 */
public class Compare<K extends Comparable<K>,V> extends Words<K,V> implements Comparable<Compare<K,V>>{

    /**
    Crea una nueva entrada en el diccionario con la clave y el valor especificados.
    @param KEY la clave de la entrada en el diccionario.
    @param VALUE el valor asociado a la clave.
    */
    public Compare(K KEY, V VALUE) {
        super(KEY, VALUE);
    }

    /**
    Crea una nueva entrada en el diccionario con la clave especificada y sin valor asociado.
    @param KEY la clave de la entrada en el diccionario.
    */
    public Compare(K KEY){
        super(KEY,null);
    }
    

    /**
    Devuelve la clave de esta entrada en el diccionario.
    @return la clave de esta entrada en el diccionario.
    */
    public K getKey(){
        return this.key;
    }

    
    /**
    Compara esta entrada en el diccionario con la entrada especificada por orden de clave.
    @param o la entrada con la que se va a comparar esta entrada.
    @return un valor negativo si esta entrada es menor que la entrada especificada, cero si son iguales, o un valor positivo si esta entrada es mayor que la entrada especificada.
    */
    @Override
    public int compareTo(Compare<K, V> o) {
        return this.key.compareTo(o.getKey());
    }

    
    /**
    Devuelve una cadena que representa esta entrada en el diccionario en el formato "(clave, valor1, valor2, ..., valorN)".
    @return una cadena que representa esta entrada en el diccionario.
    */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        String[] valores = (String[]) getValue();
        String valoresParaMadanr = "";
        for(String val: valores){
            if(!val.equals(getKey())){
                valoresParaMadanr+=val+",";
            }
        }
        s.append("("+getKey()+","+valoresParaMadanr+")");
        return s.toString();
    }


}