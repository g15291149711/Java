package TestStack;
//1.双栈解法
public interface Stack<T> {
    boolean push(T t);
    T pop();//出栈
    T peek();//返回栈顶元素，但不出栈
    int getSize();
    boolean isEmpty();
}
