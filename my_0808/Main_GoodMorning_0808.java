import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0808 {

    static int[] arr, result;
    static boolean[] visited;
    static int N,R;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        arr = new int[N];
        result = new int[R];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // perm(0);
        // permDupl(0);
        // comb(0,0);
        // combDupl(0,0);

        for (int i = 0; i < (1<<N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1<<j))==0) {
                    System.out.print(arr[j]+" ");
                }
            }
            System.out.println();
        }

    }

    static public void perm(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = arr[i];
                perm(idx+1);
                visited[i] = false;
            }
        }
    }

    static public void permDupl(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            result[idx] = arr[i];
            permDupl(idx+1);
        }
    }

    static public void comb(int idx, int cdx){
        if (cdx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == N) return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }
    static public void combDupl(int idx, int cdx){
        if (cdx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == N) return;

        result[cdx] = arr[idx];
        combDupl(idx, cdx+1);
        combDupl(idx+1, cdx);
    }
}