import java.math.BigInteger;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        //无限长整数相加
        Scanner sca = new Scanner(System.in);
        String str1 = sca.next();
        String str2 = sca.next();
        BigInteger int_1 = new BigInteger(str1);
        BigInteger int_2 = new BigInteger(str2);
        BigInteger int_3 = int_2.subtract(int_1);
        System.out.println(int_3);

    }
}
