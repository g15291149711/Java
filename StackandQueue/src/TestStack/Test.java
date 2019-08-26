package TestStack;

import javax.xml.soap.Node;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new TestArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
    }
}
