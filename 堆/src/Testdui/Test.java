package Testdui;

public class Test {
    public static void main(String[] args) {
            Integer[] data = new Integer[]{1,5,4,3,8,5,4};
            heapSort(data);
            for(int i : data){
                System.out.println(i + " ");
            }
    }
    //原地堆排序
    public static void heapSort(Integer[] data){
        int n = data.length;
        //从最后一个非叶子节点开始， 建堆  8 5 5 3 1 4 4
        for(int i = (n - 1 - 1) / 2; i >= 0; i--){
            siftdown(data,n,i);
        }
        //依次将最大值交换到数组末尾，再将交换后的数组siftDown   1 3 4 4 5 5 8
        //把和数组元素交换的最后一个元素做元素下浮，每次交换都会完成最大元素的位置确定，所以长度为i
        for(int i = n - 1; i >= 0; i--){
            swap(data,0,i);
            siftdown(data,i,0);
        }
    }
    private static void swap(Integer[] data,int x,int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    /**
     *
     * @param data
     * @param n  数组元素个数
     * @param k 调整的位置
     */
    private static void siftdown(Integer[] data,int n,int k){
        //当前元素有左孩子时
        while(2 * k + 1 < n){
            //j现在是左孩子的下标位置
            int j = 2 * k + 1;
                //取出左右孩子的最大值
            //首先判断有没有右孩子
            if(j + 1 < n){
                //如果左孩子小于右孩子，j++
                if(data[j] < data[j + 1]){
                    j++;
                }
            }
            //此时data[j] 存放了左右孩子的最大值
            if(data[k] > data[j]){
                break;
            }
            swap(data,k,j);
            k = j;
        }
    }
}
