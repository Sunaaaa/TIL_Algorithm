import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,8,1,2,7,3};        
        int N = arr.length;

        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {    // 큰 값이 앞에 있는 경우, swap
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;              
                }
            }            
        }

        System.out.println(Arrays.toString(arr));
    }    
}