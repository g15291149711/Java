import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        //aabb 2a2b
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            List<Character> list = new ArrayList<>();
            String s = sc.nextLine();
            char[] data = s.toCharArray();

            for( int i = 0; i < data.length; i++){
                int j = i;
                int count = 0;
                for(; j < data.length; j++){
                    if(data[i] == data[j]){
                        count++;
                    }else{
                        break;
                    }
                }
                count = count + 48;
                char a = (char) count;
                list.add(a);
                list.add(data[i]);
                i = j - 1;
            }
            for(char z : list){
                System.out.print(z);
            }
        }
    }
}
