package TestStack;

import java.util.Arrays;

public class TestArrayStack<T> implements Stack<T> {
    private Object[] elements;
    private int currentSize;
    private int maxSize;

    public TestArrayStack(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    @Override
    public boolean push(T t) {
        if(currentSize == elements.length){
             //扩容，扩容数组长度
            int oldSize = maxSize;
            int newSzie = oldSize << 1;
            if(newSzie + 8 > Integer.MAX_VALUE){
                System.err.println("栈太大");
                return false;
            }
            maxSize = newSzie;
            elements = Arrays.copyOf(elements,maxSize);
        }
        elements[currentSize++] = t;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.err.println("栈为空");
            return null;
        }
        T result = (T) elements[--currentSize];
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.err.println("栈为空");
            return null;
        }
        return (T) elements[currentSize - 1];
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
