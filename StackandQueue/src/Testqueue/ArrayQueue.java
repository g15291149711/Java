package Testqueue;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] element;

    public ArrayQueue(int size) {
        size = size;
        element = new Object[size];
    }

    private int size;
    private  int head;
    private int tail;
    @Override
    public void enQueue(E e) {
          if(tail == element.length){
              if(head == 0){
                  System.err.println("队列已满");
                  return;
              }else {
                  //数据搬移
                  for(int i = head; i < tail; i++){
                      element[i - head] = element[i];
                  }
                  //head 就是往左移的个数
                  tail = tail - head;
                  head = 0;
              }

          }
          element[tail++] = e;
    }

    @Override
    public E Dequeue() {
        if(isEmpty()){
            System.err.println("数组为空");
            return null;
        }
        E result = (E) element[head++];
        return result;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            System.err.println("数组为空");
            return null;
        }
        return (E) element[head];
    }

    @Override
    public int getSize() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
