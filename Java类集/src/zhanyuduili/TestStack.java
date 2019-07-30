package zhanyuduili;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("212");
        stack.push("254");
        stack.push("256");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
