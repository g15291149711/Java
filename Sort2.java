public class Sort2 {
    public static void main(String[] args) {
        int[] data = new int[]{5,6,7,1,2,8,3};
        guibingSort(data);
        for(int i : data){
            System.out.print(i + " ");
        }
    }
    public static void guibingSort(int[] data){
        if(data.length <= 1){
            return;
        }
        int p = 0;
        int q = data.length - 1;
        mergeSort(data,p,q);
    }
    public static void mergeSort(int[] data,int p,int q){
        if(p >= q){
            return;
        }
        int mid = (p + q) / 2 ;
        mergeSort(data,p,mid);
        mergeSort(data,mid + 1, q);
        mergeSortInternal(data,p,mid,q);
    }
    private static void mergeSortInternal(int[] data,int p,int mid,int q){
       int i = p;
       int j = mid + 1;
       int[] temp = new int[q - p + 1];
       int k = 0;
       while(i <= mid && j <= q){
           if(data[i] <= data[j]){
               temp[k++] = data[i++];
           }else{
               temp[k++] = data[j++];
           }
       }
       int start = i;
       int end = mid;
       if(j <= q){
           start = j;
           end = q;
       }
       while(start <= end){
           temp[k++] = data[start++];
       }
       for(int z = 0; z < temp.length; z++){
           data[z + p] = temp[z];
       }
    }
}
