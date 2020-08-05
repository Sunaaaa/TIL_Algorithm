import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main_GoodMorning_0805 {

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

        result = new int[N];
        perm(0);
        permDup(0);
        swapPerm(0);
        comb(0,0);
        combDup(0,0);
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

}
