public class Work1{
    public static void main(String[] args){
        int[] x = new int[]{1,6,4,6,8,10};
        int start = 1;
        int end = 3;
        int[] y = new int[]{3,4,5};
         System.out.println("数组x中的最大值为" + arrayMaxElement(x));
         System.out.println("数组x中的最小值为" + arrayMinElement(x));
         System.out.println("数组x中的值和为" + arrayElementSum(x));
         System.out.print("数组x和数组y拼接后为");
         int[] data1 = arrayJoin(x,y);
         int[] data2 = arraySub(x,start,end);
         System.out.print("打印数组x为");
         printArray(x);
         System.out.println();
         System.out.print("数组x和数组y拼接后为");
         printArray(data1);
         System.out.println();
         System.out.print("数组x截取下标1到3的元素为");
         printArray(data2);

    }
    public static int arrayMaxElement(int[] temp){
        int max = temp[0];
        for(int i = 1; i < temp.length; i++){
             if(temp[i] > max){
                max = temp[i];
             }
        }  
        return max;
    }
    public static int arrayMinElement(int[] temp){
         int min = temp[0];
         for(int i = 1; i < temp.length; i++){
             if(temp[i] < min){
                min = temp[i];
             }
         }
         return min;
    }
    public static int arrayElementSum(int[] temp){
        int sum = 0;
        for(int i = 0; i < temp.length; i++){
            sum += temp[i];
        }
        return sum;
    }
    public static int[] arrayJoin(int[] x, int[] y){
        int[] data = new int[x.length + y.length];
        for(int i = 0; i < x.length; i++){
            data[i] = x[i];
        }
        for(int i = 0; i < y.length; i++){
            data[x.length + i] = y[i];
        }
        return data;
    }
    public static int[] arraySub(int[] x, int start, int end){
        int[] data = new int[end -start];
        for(int i = 0; i < end - start; i++){
         data[i] = x[start + i];
        }
        return data;
    }
    public static void printArray(int[] x){
      for(int i = 0; i < x.length; i++){
          System.out.print(x[i] + " ");
      }
    }
}