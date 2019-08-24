package Sequence;
//Ctrl O 覆写方法

import java.util.Arrays;

/**
 * 基于数组的线性表
 */
public class SequenceArrayImpl implements Sequence{
    private Object[] element;
    private static final int DEFAULT_CAPCITY = 10;
    private int size;
    private static final int MAX_CAPCITY = Integer.MAX_VALUE - 8;

    public SequenceArrayImpl(Object[] element) {
        this.element = new Object[DEFAULT_CAPCITY];
    }

    @Override
    public void add(Object data) {
        if(size + 1 > element.length){
            ArrayIndex(size);
        }
        element[++size] = data;
    }

    @Override
    public boolean remove(int index) {
        ranchmark(index);
        int moveSize = size - index -1;
        if(moveSize > 0){
            System.arraycopy(element,index + 1,element,index,moveSize);
        }
        return true;
    }

    @Override
    public Object get(int index) {
        ranchmark(index);
        return element[index];
    }

    @Override
    public boolean contains(Object data) {
         for(int i = 0; i < element.length; i++){
             if(data == element[i]){
                 return true;
             }
         }
         return false;
    }

    @Override
    public Object set(int index, Object newdata) {
         ranchmark(index);
         Object obj = element[index];
         element[index] = newdata;
         return obj;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    private void ArrayIndex(int minSize){
         if(minSize > element.length){
                grow(minSize);
         }
    }
    private void grow(int minSzie){
         int oldSize = element.length;
         int newSize = oldSize << 1;
         if(newSize < minSzie){
             newSize = minSzie;
         }
         if(newSize > MAX_CAPCITY){
             throw new IndexOutOfBoundsException("数组过大");
         }
         element = Arrays.copyOf(element,newSize);
    }
    private void ranchmark(int index){
        if(index < 0 || index > element.length){
            throw new IndexOutOfBoundsException("suoyinbucunzai");
        }
    }
}
