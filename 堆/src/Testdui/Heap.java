package Testdui;

import java.util.Comparator;

public class Heap<E> {
    private Comparator<E> comparable;
    private int size;
    private E[] elements;
    private final static int DEFAULT_CAPCATTY = 10;
    public Heap() {

    }

    public Heap(Comparator<E> comparable) {
        this.comparable = comparable;
    }

    public Heap(int initsize) {
       elements = (E[]) new Object[initsize];
    }

    private void grow(E[] elements){
        int oldsize = elements.length;

    }

    private void add(E e){
       if(isEmpty()) {
          elements[0] = e;
       }
       elements[size++] = e;

    }

    public E findMax(){
       if(isEmpty()){
           throw new IndexOutOfBoundsException("heap is empty");
       }
       return elements[0];
    }

    /**
     * heapify()
     * @param
     * @return
     */
/*    public E Heap(E[] arr){
        elements = (E[]) new Object[arr.length];
        for(int i = 0; i < arr.length; i++)
            elements[i] = arr[i];
            size = elements.length;
            for(int i = ((arr.length - 1 - 1) / 2);i >= 0; i--){

            }
            re
    }*/

    private int size(){
        return size;
    }

    private boolean isEmpty(){
        return size == 0;
    }
}