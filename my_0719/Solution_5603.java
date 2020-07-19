import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5603 {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int total = 0;
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];

            int minIdx = 0, maxIdx = 0;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                total += arr[i];
                if (min > arr[i]) {
                    min = arr[i];
                    minIdx = i;
                }
                if (max < arr[i]) {
                    max = arr[i];
                    maxIdx = i;
                }
            }   // 입력 받기 끝

        }

    }
}