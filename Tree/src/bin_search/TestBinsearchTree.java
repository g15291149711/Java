package bin_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBinsearchTree<E extends Comparable<E>> implements Ibin_serch<E>{
    private Node root; //根节点
    private int size;
    private class Node{
        E data;
        Node left;
        Node right;
        public Node(E data) {
            this.data = data;
        }
    }
    @Override
    public void add(E e) {
        root = add(root,e);
        /*if(root == null){
            Node node = new Node(e);
            root = node;
            size++;
        }
        //递归的寻找节点插入位置
        add(root,e);*/
    }
    //以指定的node为根节点，插入指定元素e的节点
    //返回插入后树的根节点
    private Node add(Node node,E e){
        if(node == null){
            Node newNode = new Node(e);
            size++;
            return newNode;
        }
        //判断此时e到底在左树插入还是右树插入
        if(e.compareTo(node.data) < 0){
            node.left = add(node.left,e);
        }
        if(e.compareTo(node.data) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

   /* private void add(Node node,E e){
        if(node.data.compareTo(e) == 0){
            return;
        }
        //找到插入位置在左子树插入
        else if(e.compareTo(node.data) < 0 && node.left == null){
            Node newNode = new Node(e);
            node.left = newNode;
            size++;
        }
        else if(e.compareTo(node.data) > 0 && node.right == null){
            Node newNode = new Node(e);
            node.right = newNode;
            size++;
        }
        else if(e.compareTo(node.data) < 0){
            //递归寻找左树插入位置
            add(node.left,e);
        }
        else if(e.compareTo(node.data) > 0){
            add(node.right,e);
        }
    }*/
    @Override
    public boolean contains(E e) {
        if(root == null){
            return false;
        }
        //从根节点开始递归的查找元素
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        //终止条件
        if(node == null){
            return false;
        }
        if(e.equals(e)){
            return true;
        }
        else if(e.compareTo(node.data) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    /**
     * 以当前节点作为根节点进行前序遍历
     */
    @Override
    public void preOrder() {
          preOrder(root);
    }
    private void preOrder(Node node){
         if(node == null){
             return;
         }
        System.out.println(node.data);
         preOrder(node.left);
         preOrder(node.right);
    }

    @Override
    public void inOrder() {
            inOrder(root);
    }
    //以node为根节点进行中序遍历
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    @Override
    public void postOrder() {
            postOrder(root);
    }


    private void postOrder(Node node){
        if(node == null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);
    }
    @Override
    public void LeverOrder() {

    }


    @Override
    public E getMin() {
        if(root == null){
            throw new IllegalArgumentException("yichang");
        }
        Node Min = getMin(root);
        return Min.data;
    }
    private Node getMin(Node  node){
        if(node.left == null){
            return node;
        }
        return getMin(node.left);
    }
    @Override
    public E getMax() {
       if(root == null){
           throw new IllegalArgumentException("BST is Empty");
       }
       Node Max = getMax(root);
       return Max.data;
    }
    private Node getMax(Node node){
        if(node.right == null){
            return node;
        }
        return getMax(node.right);
    }
    @Override
    public E removeMin() {
        E result = getMin();
        root = removeMin(root);
        return result;
    }
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public E removeMax() {
        E result = getMax();
        root = removeMax(root);
        return result;
    }
     private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
     }
    @Override
    public void remove(E e) {
        root = remove(root,e);
    }

    /**
     * 删除以node为根节点且值为e的节点
     * 返回删除后的二叉树根节点
     * @param node
     * @return
     */
    private Node remove(Node node,E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.data) < 0) {
            node.left = remove(node.left,e);
        }
        if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right,e);
        }
        // 此时node就为需要删除的节点
        else {
            // 若此时节点只有一边孩子
            if (node.left != null && node.right == null) {
                Node leftNode = node.left;
                size --;
                node.left = null;
                return leftNode;
            }
            if (node.right != null && node.left == null) {
                Node rightNode = node.right;
                size --;
                node.right = null;
                return rightNode;
            }
            if (node.left != null && node.right != null) {
                // 找到前驱或后继节点
                Node successor = getMin(node.right);
                successor.left = node.left;
                successor.right = removeMin(node.right);
                node.left = node.right = null;
                return successor;
            }
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }
}
