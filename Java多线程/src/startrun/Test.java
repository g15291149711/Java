package startrun;

public class Test {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,8,5,4,6,9};
        Sort(data);
        for(int i : data){
            System.out.print(i + " ");
        }
    }
    public static void Sort(int[] data){
        if(data.length <= 1){
            return;
        }
        int step = data.length / 2;
        while(step >=  1) {
            for (int i = step; i < data.length; i++) {
                 int value = data[i];
                 int j = i - step;
                 for(; j >= 0; j -= step){
                     if(data[j] > value){
                         data[j + step] = data[j];
                     }else{
                         break;
                     }
                 }
                 data[j + step] = value;
            }
            step = step / 2;
        }
    }
}
