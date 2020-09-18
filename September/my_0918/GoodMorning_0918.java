package September.my_0918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodMorning_0918 {
    static int[] arr;
    static int N, R, v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        v = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // perm(new int[R], 0);
        // permDup(new int[R], 0);
        // comb(new int[R], 0, 0);
        combDup(new int[R], 0, 0);

    }

    private static void combDup(int[] result, int idx, int cdx) {
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        combDup(result, idx, cdx+1);
        combDup(result, idx+1, cdx);
    }

    private static void comb(int[] result, int idx, int cdx) {
        if (cdx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        comb(result, idx+1, cdx+1);
        comb(result, idx+1, cdx);
    }

    private static void permDup(int[] result, int idx) {
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));            
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            result[idx] = arr[i];
            perm(result, idx+1);
        }
    }

    private static void perm(int[] result, int idx) {
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));            
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((v & (1<<i))==0) {
                v |= (1<<i);
                result[idx] = arr[i];
                perm(result, idx+1);
                v &= ~(1<<i);
            }            
        }
    }
}
