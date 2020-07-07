import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,8,1,2,7,3}; 
        int N = arr.length;

        System.out.println(Arrays.toString(arr));

        int min = 0;
        int min_idx = 0;
        for (int i = 0; i < N-1; i++) {
            min = arr[i];
            min_idx = i;
            for (int j = i+1; j < N; j++){
                if (arr[j] < min) {
                    min = arr[j];
                    min_idx = j;                   
                }                                
            }            
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}