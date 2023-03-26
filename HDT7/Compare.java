/**
 *Sofia Garcia - 22210
 * Tomado de referencia del libro Java Structure 
 * @param <K>
 * @param <V>
 */
public class Compare<K extends Comparable<K>,V> extends Words<K,V> implements Comparable<Compare<K,V>>{

    public Compare(K KEY, V VALUE) {
        super(KEY, VALUE);
    }

    public Compare(K KEY){
        super(KEY,null);
    }
    
    /** 
     * @return K
     */
    public K getKey(){
        return this.key;
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Compare<K, V> o) {
        return this.key.compareTo(o.getKey());
    }

    
    /** 
     * @return String
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