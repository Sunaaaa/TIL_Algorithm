package my_0827;

import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0827 {
    static char[] arr, result;
    static int N, R, v;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        R = Integer.parseInt(sc.next());
        v = 0;
        arr = new char[N];
        result = new char[R];
        visited = new boolean[N];

        System.out.println("N"+N);
        System.out.println("R"+R);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next().charAt(0);
        }

        // perm(0);
        // permDup(0);
        // comb(0,0);
        // combDup(0,0);
        subset(0);

    }

    static public void perm(int idx){
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = arr[i];
                perm(idx+1);
                visited[i] = false;
            }
        }
    }

    static public void permDup(int idx){
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            result[idx] = arr[i];
            perm(idx+1);
        }
    }

    static public void comb(int idx, int cdx){
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }

    static public void combDup(int idx, int cdx){
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        combDup(idx, cdx+1);
        combDup(idx+1, cdx);
    }

    static public void subset(int idx){
        if (idx == visited.length) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i]+"");
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