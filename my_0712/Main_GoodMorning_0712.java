import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0712 {

static int[] arr, result;
static int N, v, R;
static boolean[] visited;
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    R = sc.nextInt();
    arr = new int[N];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
    }

    v = 0;
    result = new int[N];
    // perm(0);
    // permDup(0);
    // comb(0,0);
    // combDup(0,0);

    visited = new boolean[R];
    subset(0);

}

    static void subset(int idx){
        if (idx == R) {
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
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
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
        for (int i = 0; i < arr.length; i++) {
            result[idx] = arr[i];
            permDup(idx+1);
        }
    }

    static void comb(int idx, int cdx){
        if (cdx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == R) return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }

    static void combDup(int idx, int cdx){
        if (cdx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == R) return;

        result[cdx] = arr[idx];
        combDup(idx, cdx+1);
        combDup(idx+1, cdx);
    }

}