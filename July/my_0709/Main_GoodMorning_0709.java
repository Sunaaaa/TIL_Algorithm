import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0709 {

    static int N, v, R;
    static int[] arr, result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        result = new int[R];
        v = 0;
        // perm(0);
        // permDup(0);
        // comb(0,0);
        // combDup(0,0);

        visited = new boolean[N];
        // subset(0);

        do {
            System.out.println(Arrays.toString(arr));
        } while (next_perm());

        System.out.println("-----");

        do {
            System.out.println(Arrays.toString(arr));
        } while (prev_perm());


    }

    static void perm(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((v & (1<<i))==0) {
                result[idx] = arr[i];
                v |= (1<<i);
                perm(idx+1);
                v &= ~(1<<i);
            }
        }
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

    static void subset(int idx){
        if (idx == visited.length){
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]){
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

    static boolean next_perm(){
        int i = N-1;
        int j = N-1;
        while (i>0 && arr[i]<= arr[i-1]) i--;
        if (i <= 0) return false;
        while (arr[j]<= arr[i-1]) j--;
        int t = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = t;

        j = N-1;
        while (i<j) {
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

            i++;
            j--;
        }
        return true;
    }
    static boolean prev_perm(){
        int i = N-1;
        int j = N-1;
        while (i>0 && arr[i]>= arr[i-1]) i--;
        if (i <= 0) return false;
        while (arr[j]>= arr[i-1]) j--;
        int t = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = t;

        j = N-1;
        while (i<j) {
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

            i++;
            j--;
        }
        return true;
    }
}