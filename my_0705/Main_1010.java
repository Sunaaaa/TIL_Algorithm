import java.util.Scanner;

public class Main_1010 {
    
    static int N, R;
    static int cnt;
    static int[][] sum;

    public static void main(String[] args) {       
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            cnt = 0;
            N = sc.nextInt();
            R = sc.nextInt();
            // comb(0, 0);
            sum = new int[N+1][R+1];

            cnt = combDP(N, R);

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }


    static int combDP(int n, int r){
        if (n == r || r == 0 ) return 1;
        if (sum[n][r] > 0) return sum[n][r];
        sum[n][r] = combDP(n-1, r-1) + combDP(n-1, r);
        return sum[n][r];
    }
}