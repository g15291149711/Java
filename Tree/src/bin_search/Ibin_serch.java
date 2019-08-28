package bin_search;

public interface Ibin_serch<E> {
    void add(E e);
    boolean contains(E e);
    void preOrder();
    void inOrder();
    void postOrder();
    void LeverOrder();
    E getMin();
    E getMax();
    E removeMin();
    E removeMax();
    void remove(E e);
    int size();
}
