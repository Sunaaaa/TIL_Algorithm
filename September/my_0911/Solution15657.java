package September.my_0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15657 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());            
        }
        Arrays.sort(arr);
        reComb(new int[M], 0, 0);

        System.out.print(sb.toString());

    }

    static private void reComb(int[] result, int idx, int cdx){
        if (cdx == M) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx == N) return;
        result[cdx] = arr[idx];
        reComb(result, idx, cdx+1);
        reComb(result, idx+1, cdx);
    }
}
