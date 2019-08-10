package fanixng;
//可变参数
public class Test {
    public static void main(String[] args) {
        //设计一个方法，用于计算仍以参数的整数的相加结果
        System.out.println(sum("1" ,1,3,5,7,9));//随意参数的内容，随意个数
        System.out.println(sum("lalala",new int[]{1,2,3,4,5}));//可变参数可以接受数组
        //如果要传递多类参数，可变参数一定要放在最后，并且只能设置一个可变参数
    }
    public static int sum(String name,int ... data){//实际上还是一个数组 int[] data
        System.out.println(name);
        int sum = 0;
        for(int i = 0; i < data.length; i++){
             sum += data[i];
        }
        return sum;
    }
}
//静态导入：import static ...          .*;