public class Test4 {
    public static void main(String[] args) {
        int[] data = new int[]{1,3,5,4,2,1,3,2};
        candy(data);
    }
    public static int candy(int[] ratings) {
        int[] data = new int[ratings.length];
        int n = data.length;
        data[0] = 1;

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                data[i] = data[i - 1] + 1;
            }else{
                data[i] = 1;
            }
        }

        for(int j = n - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1] && data[j] <= data[j + 1]){
                data[j] = data[j + 1] + 1;
            }
        }

        int a = 0;
        for(int i : data){
            a += i;
        }
        return a;
    }
}
