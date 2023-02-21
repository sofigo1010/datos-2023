/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: StackFactory.java
 * Fecha: 21/02/2023
 */

public class StackFactory {
    
    /** Crea los diferentes tipos de stack
     * @param tipodestack
     * @return IStack<T>
     */
    public static <T> IStack<T> CrearStack (int tipodestack, int tipolista){
        if (tipodestack == 1){
            return new ArraylistStack<T>();
        }
        else if (tipodestack == 2){
            return new VectorStack<T>();
        }
        else if (tipodestack==3){
                return CrearStacklISTA(tipolista);
        }
        else{
            throw new IllegalArgumentException("Tipo invalido");
        }
    }

    
    /** De ser lista, crea una stack de tipo list
     * @param tipodestack
     * @return IStack<T>
     */
    public static <T> IStack<T> CrearStacklISTA (int tipodestack){
        if (tipodestack ==1){
            return new ListaSimpleStack<T>();
        }
        else if (tipodestack ==2){
            return new ListaDobleStack<T>();
        }
        else{
            throw new IllegalArgumentException("Tipo invalido");
        }
    }

}
