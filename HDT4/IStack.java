/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: IStack.java
 * Fecha: 21/02/2023
 */

 /**
  * Stack
  * Interface de un Stack.
  */
 public interface IStack<T> {
 
    /**
     * Agrega un elemento al tope de la pila.
     * 
     * @param i el elemento a agregar
     */
    void push(T item);

    /**
     * Elimina y retorna el elemento del tope de la pila.
     * 
     * @return el elemento en el tope de la pila
     * @throws NoSuchElementException si la pila está vacía
     */
    T pop();

    /**
     * Retorna el elemento del tope de la pila sin eliminarlo.
     * 
     * @return el elemento en el tope de la pila
     * @throws NoSuchElementException si la pila está vacía
     */
    T peek();

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Retorna el número de elementos en la pila.
     * 
     * @return el tamaño de la pila
     */
    int size();
 
 }
