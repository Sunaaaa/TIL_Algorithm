import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3040 {

    static int[] arr, result;
    static boolean flag;
    static int c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];    
        result = new int[7];    
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        flag = false;
        go(0,0,0);
    }

    static void go(int idx, int cdx, int sum){
        if (flag) {
            return;
        }
        if (sum > 100) {
            return ;
        }
        if (cdx == 7) {
            if (sum == 100) {
                Arrays.sort(result);
                for (int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
                flag = true;
                return;
            }
            return;
        }
        if (idx == 9) return;
        // sum+=arr[idx];
        result[cdx] = arr[idx];
        go(idx+1, cdx+1, sum+arr[idx]);
        go(idx+1, cdx, sum);
    }
}