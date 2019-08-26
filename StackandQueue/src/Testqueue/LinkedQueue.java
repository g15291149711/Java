package Testqueue;

public class LinkedQueue<T> implements Queue<T>{
    private Node head;
    private Node tail;
    private int currentSize;
     private class Node{
         private T data;
         private Node next;

         public Node(T data, Node next) {
             this.data = data;
             this.next = next;
         }
     }
    @Override
    public void enQueue(T t) {
         Node newNode = new Node(t,null);
         if(head ==null){
             head = tail = newNode;
         }else{
             tail.next = newNode;
             tail = newNode;
         }
         currentSize++;
    }

    @Override
    public T Dequeue() {
         if(isEmpty()){
             System.err.println("当前队列为空");
             return null;
         }
         T result = head.data;
         head = head.next;
         currentSize--;
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.err.println("当前队列为空");
            return null;
        }
        return head.data;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
