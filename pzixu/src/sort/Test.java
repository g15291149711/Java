package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//选择排序 默认全是未排序的
//插入排序 默认第一个是已排序空间
public class Test {
    public static void main(String[] args) {
      int[] data = new int[]{6,7,4,8,2,9};
        quicksort(data);
      print(data);
    }
    public static void quicksort(int[] data){
        int n = data.length;
        if(n <= 1){
            return;
        }
        quickSort(data,0,n - 1);
    }
    public static void quickSort(int[] data,int l,int r){
        if(r - l <= 15){
            zhijiecharukuaipaisort(data,l,r);
            return;
        }
        int q = pritition3(data,l,r);
        quickSort(data,l,q - 1);
        quickSort(data,q + 1,r );
    }
    private static int pritition3(int[] data,int l,int r){
        int randomIndex = (int)(Math.random() * (r-l+1) + l);
        swap(data,l,randomIndex);
        int v = data[l];
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while(i < gt){
            if(data[i] < v){
                swap(data,lt + 1,i);
                lt++;
                i++;
            }else if(data[i] > v){
                swap(data,gt - 1,i);
                gt--;
            }else{
                i++;
            }
        }
        swap(data,l,lt);
        return lt;
    }
    private  static int pritition2(int[] data,int l,int r){
        int randomIndex = (int)(Math.random() * (r-l+1) + l);
        swap(data,l,randomIndex);
        int v = data[l];
        int i = l + 1;
        int j = r;
        while(true){
            while(i <= r && data[i] < v){
                i++;
            }
            while(j >= l + 1 && data[j] > v){
                j--;
            }
            if(i > j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,l,j);
        return j;
    }
    /**
     * 分区点选取方法
     * @param  data 待排序的数组
     * @param l 数组最左元素
     * @param r 数组最右元素
     */
    private static int pritition(int[] data,int l,int r){
        //默认比较元素为排序数组的第一个元素
        int randomIndex = (int)(Math.random() * (r-l+1) + l);
        swap(data,l,randomIndex);
        int v = data[l];
        int j = l;
        int i = l + 1;
        for(;i <= r;i++){
             //每当碰到小于比较元素的值与j + 1位置交换，小于区间长度加一
            if(data[i] < v){
                swap(data,j + 1,i);
                j++;//区间加一
            }
        }
        swap(data,l,j);
        return j;
    }
    private static void swap(int[] data,int x,int y){
            int temp = data[x];
            data[x] = data[y];
            data[y] = temp;
    }
    public static void guibingsort(int[] data){
        int n = data.length;
        if(n <= 1){
            return;
        }
        mergeSort(data,0,n - 1);
    }
    private static void mergeSort(int[] data,int low,int high){
        int mid = low + (high - low)/2;
        if(low >= high){
            return;
        }
        //左边小数组
        mergeSort(data,0,mid);
        //右边小数组
        mergeSort(data,mid + 1,high);
        //合并
        merge(data,low,mid,high);
    }
    private static void merge(int data[], int p,int q,int r){
        int i = p;
        int j = q + 1;
        int[] temp = new int[r - p + 1];//0——————r - p
        int k = 0;
        while(i <= q && j <= r){//*
            //小于等于来保持有序性
            if(data[i] <= data[j]){
                temp[k++] = data[i++];
            }else{
                temp[k++] = data[j++];
            }
        }
        //判断俩个数组中哪个还有元素
        int start = i;
        int end = q;
        if(j <= r){///**
            start = j;
            end = r;
        }
        while(start <= end){//将剩余数组拷贝回temp数组
            temp[k++] = data[start++];
        }
        for(i = 0; i <= r - p; i++){//将temp中的数组拷贝回data
        data[p + i] = temp[i];
    }
    }
    public static void xuanzesort(int[] data){
        int n = data.length;
        if(n <= 1){
            return;
        }else{
           for(int i = 0;i < n - 1; i++){
               int mix = data[i];
               for(int j = i + 1; j < n; j++){
                   if(mix > data[j]){
                       mix = j;
                   }
               }
               if(mix != i){//判断最小值是否是你默认的最小值
                   int temp = data[i];
                   data[i] = data[mix];
                   data[mix] = temp;
               }
           }
        }
    }
    public static void xiersort(int[] data){
        int n = data.length;
        if(n <= 1){
            return;
        }else{
            int step = n / 2;
            while(step >= 1){
                for(int i = step; i < n; i++){
                    int value = data[i];
                    int j = i - step;
                    for(; j >= 0; j -= step){
                        if(data[j] > value){
                            data[j + step] = data[j];//将前一个元素后移step
                        }else{
                            break;
                        }
                    }
                    data[j + step] = value;//插入
                }
                step = step / 2;
            }
        }
    }
    public static void erfenchazhao(int [] data){
        int n = data.length;
        if(n <= 1){
            return;
        }else{
           for(int i = 1;i < n; i++){
               int value = data[i];
               int low = 0;
               int high = i - 1;
               int j = i - 1;
               while(low <= high){
                   int mid = low + (high - low)/2;
                   if(value > data[mid]){
                       low = mid + 1;
                   }else {
                       high = mid - 1;
                   }
               }
               for(;j > high; j--){
                   data[j + 1] = data[j];
               }
               data[j + 1] = value;
           }
        }
    }
    public static void kuaisusort(int [] data){
       int n = data.length;
       if(n <= 1){
           return;
        }else{
           for(int i = 1; i < n; i ++){
               int value = data[i];
               int j = i - 1;
               for(; j >= 0; j--){
                  if(data[j] > value){
                      data[j + 1] = data[j];
                  }else {
                      break;
                  }
               }
               data[j + 1] = value;
           }
       }
    }
    public static void print(int[] data){
        for(int i : data){
            System.out.print(i + " ");
        }
    }
    public static void bubblesort(int[] data){
       int n = data.length;
       if(n <= 1){
           return;
       }else{
           for(int i = 0; i < n; i++){
               int temp = 0;
               for(int j = 0; j < n - i - 1; j++){
                   if(data[j] > data[j + 1]){
                       temp = data[j + 1];
                       data[j + 1] =data[j];
                       data[j] = temp;
                   }
               }
           }
       }
    }
    private static void zhijiecharukuaipaisort(int[] data,int l,int r){
        if(l >= r){
            return;
        }else{
            for(int i = l + 1;i <= r;i++){
                int value = data[i];
                int j = i;
                for(;j > l && data[j - 1] > value; j--){
                   data[j] = data[j - 1];
                }
                data[j] = value;
            }
        }
    }
}
