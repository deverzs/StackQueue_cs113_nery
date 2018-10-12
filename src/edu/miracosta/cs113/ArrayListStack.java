package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
    private static final int INITIAL_CAPACITY = 10;
    private ArrayList<E> theData;

    public ArrayListStack() {
        theData= new ArrayList<E>(INITIAL_CAPACITY);

    }
    @Override
    public boolean empty() {
        return theData.isEmpty();
    }

    @Override
    public E peek() {
        if (theData.isEmpty()) {
            throw new EmptyStackException() ;
        }
        int length = theData.size() ;
        return theData.get(length-1);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw  new EmptyStackException() ;
        }
        int length = theData.size() ;
        return theData.remove(length-1) ;
    }

    @Override
    public E push(E obj) {
        theData.add(obj) ;
        return obj;
    }


}
