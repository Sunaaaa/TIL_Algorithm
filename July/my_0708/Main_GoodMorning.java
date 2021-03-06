import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning {

    static int N, v;
    static int[] arr, result;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        result = new int[N];
        v = 0;
        // perm(0);
        // permDup(0);
        // comb(0,0);
        // combDup(0, 0);

        visited = new boolean[N];
        subset(0);

    }
    static void subset(int idx){
        if (idx == visited.length) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        visited[idx] = true;
        subset(idx+1);
        visited[idx] = false;
        subset(idx+1);
    }

    static void perm(int idx){
        if (idx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < result.length; i++) {
            if ((v & (1<<i))==0) {
                result[idx] = arr[i];
                v |= (1<<i);
                perm(idx+1);
                v &= ~(1<<i);
            }            
        }

    }

    static void permDup(int idx){
        if (idx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < result.length; i++) {
            result[idx] = arr[i];
            permDup(idx+1);
        }
    }

    static void comb(int idx, int cdx){
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }

    static void combDup(int idx, int cdx){
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        combDup(idx, cdx+1);
        combDup(idx+1, cdx);
    }

}