package my_0910;

import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0910 {
    static int N, v;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        v = 0;
        arr = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();            
        }

        // perm(new int[N], 0);
        // rePerm(new int[N], 0);
        // comb(new int[N], 0, 0);
        reComb(new int[N], 0, 0);
    }    

    static private void perm(int[] result, int idx){
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }        

        for (int i = 0; i < N; i++) {
            if ((v&(1<<i))==0) {
                v |= (1<<i); 
                result[idx] = arr[i];               
                perm(result, idx+1);
                v &= ~(1<<i);
            }
        }

    }

    static private void rePerm(int[] result, int idx){
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }        

        for (int i = 0; i < N; i++) {
            result[idx] = arr[i];               
            rePerm(result, idx+1);
        }

    }

    static private void comb(int[] result, int idx, int cdx){
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        comb(result, idx+1, cdx+1);
        comb(result, idx+1, cdx);
    }

    static private void reComb(int[] result, int idx, int cdx){
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        reComb(result, idx, cdx+1);
        reComb(result, idx+1, cdx);
    }
}
