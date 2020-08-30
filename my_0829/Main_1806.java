import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1806 {

    static int N, M, ans;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
        numbers = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start <= N && end <= N) {
            if (sum >= M && ans > end-start) {
                ans = end-start;
            } 
            if (sum < M) {
                sum += numbers[end++];
            } else {
                sum -= numbers[start++];
            }
        }
        
        
        System.out.println(ans==Integer.MAX_VALUE?0:ans);


    }



}