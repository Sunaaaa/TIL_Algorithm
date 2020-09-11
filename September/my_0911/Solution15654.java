package September.my_0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15654 {
    static int N, M, v;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());            
        }
        Arrays.sort(arr);
        perm(new int[M], 0);

        System.out.print(sb.toString());

    }

    static private void perm(int[] result, int idx){
        if (idx == M) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((v & (1<<i))==0) {
                v |= (1<<i);
                result[idx] = arr[i];
                perm(result, idx+1);
                v &= ~(1<<i);
            }            
        }
    }
}
