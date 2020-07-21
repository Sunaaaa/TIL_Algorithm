import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7510 {
    static int[] arr;
    static int[][] range;
    static int N, Q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            range = new int[Q][2];
            arr = new int[N];
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                range[i][0] = Integer.parseInt(st.nextToken())-1;         
                range[i][1] = Integer.parseInt(st.nextToken())-1;         
            }

            for (int t = 1; t <= Q; t++) {
                int i = range[t-1][0];
                int j = range[t-1][1];
                for (; i <= j; i++) {
                    arr[i] = t;
                }
            }
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

        }
        System.out.print(sb.toString());
    }
}