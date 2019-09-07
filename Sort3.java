public class Sort3 {
    public static void main(String[] args) {
        int[] data = new int[]{5,6,7,1,2,8,3};
        quickSort(data);
        for(int i : data){
            System.out.print(i + " ");
        }
    }
    public static void quickSort(int[] data){
        if(data.length <= 1){
            return;
        }
        int p = 0;
        int q = data.length - 1;
        quick(data,p,q);
    }
    public static void quick(int[] data,int p,int q){
        if(p >= q){
            return;
        }
        int v = partical2(data,p,q);
        quick(data,p,v - 1);
        quick(data,v + 1,q);
    }
   /* public static int partical(int[] data,int p,int q){
        int random = (int) (Math.random() * (q - p + 1) + p);
        swap(data,p,random);
        int v = data[p];
        int j = p;
        for(int i = p + 1; i <= q; i++){
            if(data[i] < v){
                swap(data,i,j+1);
                j++;
            }
        }
        swap(data,p,j);
        return j;
    }*/
    public static int partical2(int[] data,int l,int r ){
       int random = (int) (Math.random() * (r - l + 1) + l);
       swap(data,random,l);
       int v = data[l];
       int i = l + 1;
       int j = r;
       while(true){
           while(i <= r && data[i] < v){
               i++;
           }
           while(j >= l+1 && data[j] > v){
               j--;
           }
           if(i > j){
               break;
           }
           swap(data,i,j);
           i++;
           j--;
       }
       swap(data,l,j);
       return j;
    }
    public static void swap(int[] data,int a,int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
