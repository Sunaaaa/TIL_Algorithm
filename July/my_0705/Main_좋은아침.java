import java.util.Arrays;
import java.util.Scanner;

public class Main_좋은아침 {

    static int[] arr;
    static int[] result;
    static int N, v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        v = 0;
        
        // perm(0);
        // permDup(0);
        swapPerm(0);
        // comb(0,0);
        // combDup(0, 0);

        System.out.println("sssss");
    }

    static void perm(int idx){      // 순열
        if (idx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((v&(1<<i))==0) {
                v |= (1<<i);
                result[idx] = arr[i];                
                perm(idx+1);
                v &= ~(1<<i);                
            }        
        }
    }

    static void permDup(int idx){      // 중복순열
        if (idx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            v |= (1<<i);
            result[idx] = arr[i];                
            permDup(idx+1);
            v &= ~(1<<i);                
        }
    }

    static void swapPerm(int idx){
        if (idx == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(i, idx);            
            swapPerm(idx+1);;
            swap(i, idx);            
        }
    }
    static void swap(int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void comb(int idx, int cdx){     // 조합
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length)return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }

    static void combDup(int idx, int cdx){     // 중복조합
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length)return;

        result[cdx] = arr[idx];
        combDup(idx, cdx+1);
        combDup(idx+1, cdx);
    }

}