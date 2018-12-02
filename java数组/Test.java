public class Test{
    public static void main(String[] args){
        //动态初始化数组
        // int[] x = new int[5];
        // System.out.println(x.length);
        // x[0] = 6;
        // x[1] = 7;
        // x[2] = 8;
        // for(int i = 0; i < x.length; i++){
        //     System.out.println(x[i]);
        // }
        // int[] x = null;
        // x = new int[3];
        // System.out.println(x.length);
        // x[0] = 1;
        // x[1] = 2;
        // x[2] = 3;
        //  for(int i = 0; i < x.length; i++){
        // System.out.println(x[i]);
        // }
        //引用传递
        // int[] x = null;
        // int[] temp = null;
        // x = new int[3];
        // x[0] = 1;
        // x[1] = 2;
        // x[2] = 3;
        // for(int i = 0; i < x.length; i++){
        //     System.out.println(x[i]);
        // } 
        // temp = x;
        // //如果发生引用传递，不能出现[]
        // temp[0] = 55;
        // System.out.println(x[0]);
        //静态初始化
        // int[] x = new int[]{1,2,3};
        // System.out.println(x.length);
        // System.out.println(x[0]);
        //匿名数组
        //System.out.println(new int[]{1,2,3,4,5,6});
        //int[] data = new int[]{1,2,3,4,5,6};匿名数组只能使用一次
        //二位数组
        //动态初始化
        //int[][] data = new int[][]
        //静态初始化
        //int[][] data = new int[][]{}
        // int[][] data = new int[][]{
        //     {1,2},{3,4,5},{6,7,8}
        // };
        // for(int x = 1; x <data.length; x++){
        //     for(int y = 0; y < data.length; y++){
        //         System.out.println(data[x][y] + "、");
        //     }
        // }
        //方法与数组互操作
          int[] data = init();
          modify(data);
          printArray(data);
    }
    public static void printArray(int[] temp){
          for(int i : temp){
              System.out.print(i + "、");
          }
    }
    public static int[] init(){
        return new int[]{1,2,3,4,5};
    }
    public static void modify(int[] arr){
           for(int i = 0; i < arr.length; i++){
               arr[i] *= 2;
           }
    }
}