package OJ;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.*;
public class TestOj{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            char[] data = s.toCharArray();
            if(s.length() <= 1){
                System.out.println("YES");
                break;
            }
            for(int i = 0; i < s.length(); i++){
                if(data[s.length() - 2] == data[0]) {
                    if (s.length() - 2 - i <= i) {
                        System.out.println("YES");
                        break;
                    } else if (data[s.length() - 2 - i] != data[i]) {
                        System.out.println("NO");
                        break;
                    }
                }else{
                    if (s.length() - 1 - i <= i + 1) {
                        System.out.println("YES");
                        break;
                    } else if (data[s.length() - 1 - i] != data[i + 1]) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
        }
    }
}