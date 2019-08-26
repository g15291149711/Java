package Testqueue;

public interface Queue<E> {
       void enQueue(E e);
       E Dequeue();
       E peek();
       int getSize();
       boolean isEmpty();
}
