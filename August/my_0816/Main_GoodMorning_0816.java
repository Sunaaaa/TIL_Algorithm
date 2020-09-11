package TIL_Algorithm.my_0816;

import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0816 {
    static int N, R, v;
    static int[] arr, result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());        
        R = Integer.parseInt(sc.next());     

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

    private static void subset(int i) {
        if (i == visited.length){
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]){
                    System.out.print(arr[j]+" ");
                }                
            }
            System.out.println();
            return;
        }

        visited[i] = true;
        subset(i+1);
        visited[i] = false;
        subset(i+1);
    }

    private static void comb(int i, int j) {
        if (j == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        if (i == arr.length) return;

        result[j] = arr[i];
        comb(i+1, j+1);
        comb(i+1, j);

    }

    private static void combDup(int i, int j) {
        if (j == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        if (i == arr.length) return;

        result[j] = arr[i];
        combDup(i, j+1);
        combDup(i+1, j);

    }

    private static void permDup(int i) {
        if (i == result.length) {
            System.out.println("PERMDUP");
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int j = 0; j < N; j++) {
            result[i] = arr[j];
            permDup(i+1);
        }
    }

    private static void perm(int i) {
        if (i == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int j = 0; j < N; j++) {
            if ((v & (1<<j))==0) {
                result[i] = arr[j];
                v |= (1<<i);
                perm(i+1);
                v &= ~(1<<i);
            }
        }
   }
}