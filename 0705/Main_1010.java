import java.util.Scanner;

public class Main_1010 {
    
    static int N, R;
    static int cnt;

    public static void main(String[] args) {       
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            cnt = 0;
            N = sc.nextInt();
            R = sc.nextInt();
            comb(0, 0);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void comb(int idx, int cdx){
        if (cdx == N) {
            cnt += 1;
            return;
        }

        if (idx == R) return;

        comb(idx+1, cdx+1);
        comb(idx+1, cdx);        
    }
}