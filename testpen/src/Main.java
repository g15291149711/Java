import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //1,2,2 输出 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] str = s.split(",");
            int[] data = new int[str.length];
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < data.length; i++){
                data[i] = Integer.parseInt(str[i]);
            }
            list.add(data[0]);
            for(int i = 1; i < data.length; i++){
                 if(list.indexOf(data[i]) == -1){
                     list.add(data[i]);
                 }
            }
            System.out.println(list.size());
        }
    }
}
