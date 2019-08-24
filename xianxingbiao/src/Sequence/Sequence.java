package Sequence;

public interface Sequence {
    /**
     * 在线性表中添加元素
     * @param data 要存储的元素
     */
    void add(Object data);

    /**
     * 线性表中删除元素
     * @param index 要删除的元素下标
     * @return 是否删除成功
     */
    boolean remove(int index);

    /**
     * 在线性表中查找指定索引的元素
     * @param index 要查找的索引
     * @return
     */
       Object get(int index);

    /**
     * 判断现行表中是否由指定元素
     * @param data 要查找的元素内容
     * @return
     */
    boolean contains(Object data);

    /**
     * 修改线性表中指定元素的内容
     * @param index 要修改的元素下标
     * @param newdata 修改后的内容
     * @return
     */
    Object set(int index,Object newdata);

    /**
     * 返回当前线性表元素
     * @return
     */
    int size();

    /**
     * 直接清空线性表
     */
    void clear();

    /**
     * 将线性表转为数组
     * @return
     */
    Object[] toArray();
}
