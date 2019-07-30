package collection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Format;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
class Personss{
    public void print(){
        System.out.println("d");
    }
}
class Students extends Personss{
    public void prints(){
        System.out.println("d");
    }
    private void sum(){
        System.out.println("sd");
    }
}
public class Tets {
    public static void main(String[] args) {
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];
    }
}
