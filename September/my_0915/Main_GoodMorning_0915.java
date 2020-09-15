package September.my_0915;

import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0915 {

    static int[] arr, result;
    static int N, R, v;    
    static boolean[] visited;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        v = 0;

        arr = new int[N];
        result = new int[R];

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // perm(0);
        // permDup(0);
        // comb(0,0);
        // combDup(0,0);
        subset(0);

    }

    public static void perm(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((v & (1<<i))==0) {
                v |= (1<<i);
                result[idx] = arr[i];
                perm(idx+1);
                v &= ~(1<<i);
            }
        }
    }


    public static void permDup(int idx){
        if (idx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < N; i++) {
            result[idx] = arr[i];
            permDup(idx+1);
        }
    }

    public static void comb(int idx, int cdx){
        if (cdx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }

        if (idx == N) return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }

    public static void combDup(int idx, int cdx){
        if (cdx == R) {
            System.out.println(Arrays.toString(result));
            return;
        }

        if (idx == N) return;

        result[cdx] = arr[idx];
        combDup(idx, cdx+1);
        combDup(idx+1, cdx);
    }

    public static void subset(int idx){
        if (idx == N) {
            for (int i = 0; i < N; i++) {
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

}