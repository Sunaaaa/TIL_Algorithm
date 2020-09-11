import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889 {
    static int N, answer;
    static int[][] map;
    static boolean[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr = new boolean[N];
        
        answer = Integer.MAX_VALUE;
        comb(0,0);
        System.out.println(answer);
    }

    public static void comb(int cnt, int idx){
        if (cnt == N/2) {
            calc();
            return;
        }
        if (idx == arr.length) return;

        for (int i = idx; i < N; i++) {
            arr[i] = true;
            comb(cnt+1, i+1);
            arr[i] = false;
        }
    }

    public static void calc(){
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[i] && arr[j]) {
                    sum1 += map[i][j] + map[j][i];
                } else if (arr[i] == false && arr[j] == false){
                    sum2 += map[i][j] + map[j][i];
                } else continue;
            }
        }
        if (answer > Math.abs(sum1-sum2)){
            answer = Math.abs(sum1-sum2);
        }
    }
}