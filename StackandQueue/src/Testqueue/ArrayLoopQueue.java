package Testqueue;

public class ArrayLoopQueue<E> implements Queue <E>{
    private Object[] element;
    private int head;
    private int tail;
    private int size;
    public ArrayLoopQueue(int size) {
        this.size = size;
        //因为循环队列会浪费⼀个空间来判断当前队列是否已满，因此多开辟⼀块空间
        element = new Object[size + 1];
    }

    @Override
    public void enQueue(E e) {
        if((tail + 1) % element.length == head){
            System.err.println("队列满");
            return;
        }else{
            element[tail] = e;
            //加操作
            tail = (tail + 1) % element.length;
        }
    }

    @Override
    public E Dequeue() {
        if(isEmpty()){
            System.err.println("duilieweikong");
            return null;
        }
        E result = (E) element[head];
        //给后走
        head = (head + 1) % element.length;
        return result;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            System.err.println("duilieweikong");
            return null;
        }
        return (E) element[head];
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
