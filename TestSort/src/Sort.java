public class Sort {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,9,4,5,6};
        xier(data);
        for(int i : data){
            System.out.print(i + " ");
        }
    }
    public static void maopaosort(int[] data){
        if(data.length <= 1){
            return;
        }
        for(int i = 0; i < data.length;i++){
            boolean flag = false;
            for(int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j + 1]){
                    flag = true;
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
            if(!flag){
                break;
            }

        }
    }
    public static void charupaixu(int[] data){
        if(data.length <= 1){
            return;
        }
        for(int i = 1; i < data.length; i++){
            int value = data[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(data[j]  > data[j + 1]){
                    data[j + 1] = data[j];
                }else{
                    break;
                }
            }
            data[j + 1] = value;
        }
    }
    public static void erfen(int[] data){
         for(int i = 1; i < data.length; i++){
             int high = i - 1;
             int low = 0;
             int j = i - 1;
             int value = data[i];
             while(low <= high){
                 int mid = (low + high)/2;
                 if(data[mid] < value){
                     low = mid + 1;
                 }else{
                     high = mid - 1;
                 }
             }
             for(; j > high; j--){
                 data[j + 1] = data[j];
             }
             data[j + 1] = value;
         }
    }
    public static void xier(int[] data){
        int step = data.length / 2;
        while(step >= 1) {

            for (int i = step; i < data.length; i++) {
                int value = data[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
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
    public static void chooseSort(int[] data){
        for(int i = 0; i < data.length - 1; i++){
            int min = data[i];
            for(int j = i + 1; i < data.length; i++){
                if(data[j] < min){
                    int temp = data[j];
                    data[j] = min;
                    min =  temp;
                }
            }
        }
    }
}
