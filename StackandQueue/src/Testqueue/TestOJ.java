package Testqueue;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
class Imeesage{
    static void prinklasdf(){
        System.out.println("dsaf");
    }
    static void prinkldf(){
        System.out.println("dddddddddddd");
    }
    public static void main(String[] args) {
        System.out.println("llllllll");
        Thread t = new Thread(){
            @Override
            public void run() {
                prinklasdf();
            }
        };
        System.out.println(Thread.currentThread().getName());
        t.run();

        System.out.println("sdfasfsa");
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

