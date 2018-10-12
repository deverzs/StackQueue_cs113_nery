package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This generic Stack utilizes ArrayList to hold the data structure. All elements enter and exit from the same location.
 * @param <E> Generic data type to be used to implement the stack
 */
public class ArrayListStack<E> implements StackInterface<E> {
    private static final int INITIAL_CAPACITY = 10;
    private ArrayList<E> theData;

    /**
     * Constructor of the stack, initializing the stack at the INITIAL_CAPACITY
     */
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

    @Override
    public String toString() {
        String result = "[Top of stack] " ;
        int length = theData.size() ;
        for (int i = 0 ; i < length ; i++) {
            result += " " + theData.get(i) ;
        }
        result += " [<-> Exit/Enter]" ;
        return result ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null ) {
            return false ;
        }
        if (!(o instanceof ArrayListStack)) {
            return false ;
        }
        ArrayListStack anotherList = (ArrayListStack) o ;
        if (theData.size() != anotherList.theData.size()) {
            return false ;
        }
        int length = theData.size() ;
        for (int i = 0 ; i < length ; i++) {

            if (!(theData.get(i).equals(anotherList.theData.get(i)))) {
                return false ;
            }
        }
        return true ;
    }


}
