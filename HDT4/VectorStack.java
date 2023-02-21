/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: VectorStack.java
 * Fecha: 21/02/2023
 */

import java.util.Vector;

public class VectorStack<T> implements IStack<T> {
    private Vector<T> Vectorr = new Vector<>();

    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        Vectorr.add(item);
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return Vectorr.remove(size() - 1);
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return Vectorr.get(size() - 1);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return Vectorr.isEmpty();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return Vectorr.size();
    }


    
}
