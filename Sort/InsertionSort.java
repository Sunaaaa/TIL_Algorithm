import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,6,8,1,2,7,3};
        int N = arr.length;
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < 3; i++) {

            System.out.println(i + "-"+arr[i]+"----------" );
            int j = i-1;
            while (j>0 && arr[j] > arr[i]) {
                System.out.println(arr[j]>arr[i]);
                j--;
            }

            if (i != j-1) {
                int[] tmp = Arrays.copyOf(arr, N);
                arr[j] = arr[i];
                
                // 뒤로 밀기
                for (int k = 1; k < i-j+1; k++) {
                    arr[j+k] = tmp[j+k-1];
                }
            }

            System.out.print("--  중간 : " );
            System.out.println(Arrays.toString(arr));
            
        }

        System.out.println(Arrays.toString(arr));

    }
}