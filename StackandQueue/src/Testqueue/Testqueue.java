package Testqueue;

public class Testqueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayLoopQueue<Integer>(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.Dequeue());
        queue.enQueue(6);
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }
}
