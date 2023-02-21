/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: ListaDobleStack.java
 * Fecha: 21/02/2023
 */

import java.util.EmptyStackException;

import structure5.DoublyLinkedList;

public class ListaDobleStack<T> implements IStack<T>{
    private DoublyLinkedList<T> DoubleList = new DoublyLinkedList<>();

    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        DoubleList.addFirst(item);
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return DoubleList.removeFirst();
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return DoubleList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return DoubleList.isEmpty();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return DoubleList.size();
    }


}
