package TestStack;
//双栈解法：辅助一个栈，专门存放要求的数据(空间复杂度O(n))

import java.util.LinkedList;
public class TestLinkedList<T> implements Stack<T>{

    private class Node{
        private T t;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
        private Node next;
    }
    private int cuurentSize;
    private Node Top;

    @Override
    public boolean push(T t) {
        Node newNode = new Node(t,null);
        if(Top == null){
            Top = newNode;
        }else{
            newNode.next = Top;
            Top = newNode;
        }
        cuurentSize++;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("当前栈为空");
            return null;
        }
       Node result = Top;
        Top = Top.next;
        cuurentSize--;
        return (T) result.t;//返回数据
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("当前栈为空");
            return null;
        }
        return (T) Top.t;//返回数据
    }
    @Override
    public int getSize() {
        return cuurentSize;
    }

    @Override
    public boolean isEmpty() {
        return cuurentSize == 0;
    }

}
