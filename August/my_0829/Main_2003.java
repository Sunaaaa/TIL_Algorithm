import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2003 {

    static int N, M, ans;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = 0;
        numbers = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 
        int start = 0;
        int end = 0;

        int sum = 0;

        for (start = 0; start < N; start++) {
            sum += numbers[start];

            if (sum == M) {
                ans += 1;
                sum -= numbers[end++];
            } else if (sum > M){
                while (sum > M) {   // M보다 작거나 같아질 떄까지
                    sum -= numbers[end++];
                    if (sum == M) {
                        ans+=1;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);


    }



}