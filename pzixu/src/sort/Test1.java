package sort;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {
        int[] data = new int[]{6,7,4,8,2,9};
        quickSort(data);
        for(int i : data){
            System.out.print(i + "、");
        }
    }
    public static void zhijiecharuSort(int[] data){
        if(data.length <= 1){
            return;
        }
        for(int i = 1; i < data.length; i++){
            int value = data[i];
            int j = i - 1;
            for( ; j >= 0; j--){
                if(data[j] > value){
                    ///     4  1
                    data[j + 1] = data[j];
                }else{
                    break;
                }
            }
            data[j + 1] = value;
        }
    }
    public static void quickSort(int[] data) {
        if(data.length <= 1){
            return;
        }
        quickSortInternal(data,0,data.length - 1);
    }
    public static void mergeSort(int[] data){
        if(data.length <= 1){
            return;
        }
        int n =  data.length;
        int low = 0;
        int high = n - 1;
        mergeSortInternal(data,low,high);
    }
    public static void mergeSortInternal(int[] data,int p,int r){
        if(p >= r){
            return;
        }
        int mid = (r + p) / 2;
        mergeSortInternal(data,p,mid);
        mergeSortInternal(data,mid + 1,r);
        mergepar(data,p,mid,r);
    }
    public static void mergepar(int[] data,int p,int mid,int r){
        int[] array = new int[r - p + 1];
        int k = 0;
        int i = p;
        int j = mid + 1;
        while(i <= mid && j <= r){
            if(data[i] <= data[j]){
                array[k++] = data[i++];
            }else{
                array[k++] = data[j++];
            }
        }
        int start = i;
        int end = mid;
        if(j <= r){
            start =  j;
            end = r;
        }
        while(start <= end){
            array[k++] = data[start++];
        }
        for(int z = 0; z < array.length; z++){
            data[p + z] = array[z];
        }
    }

    /**
     *
     * @param data
     * @param p 开始位置
     * @param r  结束位置
     */
    private static void quickSortInternal(int[] data,int p,int r){
         if(p >= r){
             return;
         }
         int q = partition2(data,p,r);
         quickSortInternal(data,p,q - 1);
         quickSortInternal(data,q +1,r);
    }
    private static void xuanzeSort(int[] data){
        for(int i = 0; i < data.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < data.length; j++){
                if(data[j] < data[min]){
                    min = j;
                }
            }
            swap(data,min,i);
        }
    }
    private static int partition3(int[] data,int l,int r){
        int random = (int) (Math.random()*(r - l + 1) + l);
        swap(data,l,random);
        int v = data[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while(l < gt){
            if(data[i] < v){
                swap(data,i,lt + 1);
                lt++;
                i++;
            }else if(data[i] > v){
                swap(data,gt - 1,i);
                gt--;
            }else {
                i++;
            }
        }
        swap(data,lt,l);
        return lt;
    }
    private static int partition(int[] data,int l,int r){
        //随机化快排  随机选取数组中的任意一个元素和数组第一个数进行交换，默认它为基准值
        int random = (int) (Math.random() * (r -  l + 1) + l);
        swap(data,random,l);
        int v = data[l];
        int i = l + 1;
        int j = l;
        for( ; i < data.length; i++){
            if(data[i] < v){
                j++;
            }else{
                swap(data,j + 1,i);
            }
        }
        swap(data,l,j);
        return j;
    }
    private static int partition2(int[] data,int l,int r){
       int random = (int) (Math.random() * (r - l + 1) + l);
       swap(data,random,l);
       int v = data[l];
       int i= l + 1;
       int j = r;
       while(true){
           while(i <= r && data[i] < v){
               i++;
           }
           while(j > l && data[j] > v){
               j--;
           }
           if(i > j){
               break;
           }
           swap(data,i,j);
           i++;
           j--;
       }
       swap(data,j,l);
       return j;
    }
    private static void swap(int[] data,int x,int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    public static void print(int[] data){
        for(int i : data){
            System.out.print(i + "、");
        }
    }
}
