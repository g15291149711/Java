package Testvolatile;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Testdanli <K,V>{
    private HashMap<K,V> hashMap;//存放具体数据
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();//并发读锁
    private Lock writeLock = lock.writeLock();//互斥写锁
    public V get(K k){
        readLock.lock();
        return hashMap.get(k);
    }
    public void put(K k,V v){
        writeLock.lock();
        hashMap.put(k,v);
    }




    public static void main(String[] args) {

    }
}
