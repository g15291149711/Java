//上三角 输入 line=7  i=1  i<=line
//2*i-1  第i行的元素数
//第i行的空格数  line-i
//下三角
//第i行的元素数 2*（line -i)-1
//第i行的空格数 i 
//i<line
public class Test{
        public static void main(String[] args){
        int line = 7;
        for(int i = 1; i <= line; i++){
            for(int j = 1; j <= line - i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1; i <= line; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (2 * (line -i) - 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}