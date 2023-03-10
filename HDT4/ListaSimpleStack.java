/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: ListaSimpleStack.java
 * Fecha: 21/02/2023
 */

import java.util.EmptyStackException;

import structure5.SinglyLinkedList;

public class ListaSimpleStack<T> implements IStack<T>{
    private SinglyLinkedList<T> SingleList = new SinglyLinkedList<>();

    @Override
    public void push(T item) {
        // TODO Auto-generated method stub
        SingleList.addFirst(item);
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return SingleList.removeFirst();
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return SingleList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return SingleList.isEmpty();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return SingleList.size();
    }


}
