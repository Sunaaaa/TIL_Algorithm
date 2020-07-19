import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10032 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            K = Integer.parseInt(st.nextToken()); 
            arr = new int[K];

            int ans = N%K;
            if (ans == 0) {
                sb.append("#").append(tc).append(" ").append(0).append("\n");                                
            } else {
                sb.append("#").append(tc).append(" ").append(1).append("\n");                                
            }
        }

        System.out.println(sb.toString());
    }
}