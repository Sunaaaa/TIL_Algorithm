import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4676 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();
            int H = Integer.parseInt(br.readLine());    
            arr = new int[H+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < H; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] += 1; 
            }

            int sidx = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) {
                    sidx += 1;
                } else {
                    String op = "";
                    for (int k = 0; k < arr[i]; k++) {
                        op += '-';                        
                    }
                    s = s.substring(0,sidx+1) + op + s.substring(sidx+1, s.length());
                    sidx += arr[i]+1;
                }
            }

            if (arr[0] != 0) {
                String op = "";
                for (int i = 0; i < arr[0]; i++) {
                    op += '-';
                }
                s = op+s;
            }

            sb.append("#").append(tc).append(" ").append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}