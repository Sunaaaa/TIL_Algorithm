import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3499 {

    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        Queue<String> lQueue = new LinkedList<>(), rQueue = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            lQueue.clear();
            rQueue.clear();

            int term = N/2;
            if (N%2!=0) {
                term = (N/2)+1;
            }
            for (int i = 0; i < term; i++) {
                lQueue.offer(st.nextToken());
            }
            for (int i = term; i < N; i++) {
                rQueue.offer(st.nextToken());
            }
            sb.append("#").append(tc).append(" ");
            while(!rQueue.isEmpty()) {
                sb.append(lQueue.poll()).append(" ")
                .append(rQueue.poll()).append(" ");                
            }
            if (!lQueue.isEmpty()){
                sb.append(lQueue.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}