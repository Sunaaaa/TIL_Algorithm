import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0714 {
    static int[] arr, result;
    static int N, R, v;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();        
        R = sc.nextInt();        

        arr = new int[N];
        result = new int[R];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        v = 0;
        visited = new boolean[N];
        // perm(0);
        // permDup(0);
        // comb(0,0);
        combDup(0,0);

    }

    static void perm(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((v&(1<<i))==0) {
                result[idx] = arr[i];
                v |= (1<<i);
                perm(idx+1);
                v &= ~(1<<i);
            }            
        }
    }

    static void comb(int idx, int cdx){
        if (cdx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == N) return;
        
        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }

    static void permDup(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < N; i++) {
            result[idx] = arr[i];
            permDup(idx+1);
        }
    }

    static void combDup(int idx, int cdx){
        if (cdx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == N) return;
        
        result[cdx] = arr[idx];
        combDup(idx, cdx+1);
        combDup(idx+1, cdx);
    }


}