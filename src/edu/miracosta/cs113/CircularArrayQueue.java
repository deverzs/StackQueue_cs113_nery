package edu.miracosta.cs113;

import java.util.*;

public class CircularArrayQueue<E> implements Queue<E> {
   private int front ;
   private int rear ; // last index
   private int size ;
   private int capacity ;
   private static final int DEFAULT_CAPACITY = 10 ;
   private E[] theData ;


    /**
     * The constructor for the CircularArrayQueue. It initializes all variables.
     * @param initCapacity  The initial capacity of the queue specified by user
     */
    public CircularArrayQueue(int initCapacity) {
        capacity = initCapacity ;
        theData = (E[]) new Object[capacity] ;
        front = 0 ;
        rear = capacity - 1 ;
        size = 0 ;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true ;
        }
        else {
            return false ;
        }
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false ;
        E newItem = (E) o ;
        for (int i = 0 ; i < theData.length ; i++) {
            if (newItem.equals(theData[i])) {
                result = true ;
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {


        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(E o) {
        if (size==capacity) {
            throw new IllegalStateException() ;
        }
        return offer(o) ;
    }

    @Override
    public boolean remove(Object o) {
        remove(o) ;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        front = 0 ;
        rear = capacity - 1 ;
        size = 0 ;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(E item) {
        if (size == capacity) {
                reallocate() ;
        }
        size++ ;
        rear = (rear + 1) % capacity ;
        theData[rear] = item ;
        return true;
    }

    /**
     * This method reallocates the circular array to be twice as large as the original capacity
     */
    private void reallocate() {
        int newCapacity = 2 * capacity ;
        E[] newData = (E[]) new Object[newCapacity] ;
        int j = front ;
        for (int i = 0; i < size; i++) {
            newData[i] = theData[j] ;
            j = (j + 1) % capacity ;
        }
        front = 0 ;
        rear = size - 1 ;
        capacity = newCapacity ;
        theData = newData ;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw  new NoSuchElementException() ;
        }
        E result = theData[front] ;
        front = (front + 1) % capacity ;
        size-- ;
        return result;

    }

    @Override
    public E poll() {
        if (size == 0) {
            return null ;
        }
        E result = theData[front] ;
        front = (front + 1) % capacity ;
        size-- ;
        return result;
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E result = theData[front] ;
        return result;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null ;
        }
        E result = theData[front] ;
        return result;

    }
}
