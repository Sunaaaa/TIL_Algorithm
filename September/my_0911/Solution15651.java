package September.my_0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15651 {
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
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;            
        }
        rePerm(new int[M], 0);

        System.out.print(sb.toString());

    }

    static private void rePerm(int[] result, int idx){
        if (idx == M) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            result[idx] = arr[i];
            rePerm(result, idx+1);
        }
       
        
    }
}
