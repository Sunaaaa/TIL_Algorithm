import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0706 {

    static int v, N;
    static int[] arr, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();            
        }
        v = 0;

        System.out.println("---순열---");
        result = new int[N];
        perm(0);
        
        System.out.println("---중복순열---");
        result = new int[N];
        permDup(0);

        // System.out.println("---swap순열---");
        // v = 0;
        // swapPerm(0);

        System.out.println("---조합---");
        result = new int[N];
        comb(0,0);

        System.out.println("---중복조합---");
        result = new int[N];
        combDup(0,0);

        System.out.println("---부분집합---");
        subset(new boolean[N], 0);

        System.out.println("---부분집합2---");
        subset();

    }    

    static void perm(int idx){
        if (idx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((v&(1<<i))==0) {
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
        for (int i = 0; i < arr.length; i++) {
            result[idx] = arr[i];
            permDup(idx+1);
        }
    }

    static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swapPerm(int idx){
        if (idx == N) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = idx; i < result.length; i++) {
            swap(idx, i);
            swapPerm(idx+1);
            swap(idx, i);
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

    static void subset(){

        for (int i = 0; i < (1<<N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1<<j))==0) {
                    System.out.print(arr[j]+" ");
                }
            }
            System.out.println();
        }
    }

    static void subset(boolean[] res, int idx){
        if (idx == N) {
            for (int i = 0; i < res.length; i++) {
                if (res[i]) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        res[idx] = true;
        subset(res, idx+1);
        res[idx] = false;
        subset(res, idx+1);

    }
}
