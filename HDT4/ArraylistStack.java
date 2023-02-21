/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: ArraylistStack.java
 * Fecha: 21/02/2023
 */

import java.util.ArrayList;

public class ArraylistStack<T> implements IStack<T>{
    
    private ArrayList<T> stack = new ArrayList<T>();

    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        stack.add(item);
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return stack.isEmpty();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return stack.size();
    }

    
    
}
