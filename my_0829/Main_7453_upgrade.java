import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main_7453_upgrade {

    static int[] arr,brr,crr,drr, abrr, cdrr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        brr = new int[N];
        crr = new int[N];
        drr = new int[N];
        abrr = new int[N*N];
        cdrr = new int[N*N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
            crr[i] = Integer.parseInt(st.nextToken());
            drr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                abrr[idx] = arr[i] + brr[j];
                cdrr[idx++] = crr[i] + drr[j];
            }
        }

        Arrays.sort(abrr);
        Arrays.sort(cdrr);

        System.out.println(Arrays.toString(abrr));
        System.out.println(Arrays.toString(cdrr));
        
        for (int i = 0, j = cdrr.length-1; i < abrr.length && j >= 0; ) {
            System.out.print(abrr[i]+" vs "+cdrr[j]);
            if (Math.abs(abrr[i]) == Math.abs(cdrr[j])) {
                cnt+=1;
                System.out.print("____   같음");
                i++;
                j--;
            }
            else if (j >= 0 && Math.abs(cdrr[j]) > Math.abs(abrr[i]) ) { // cdrr[j] 값이 더 큰 경우
                System.out.println("_____ cd");
                j--;
            } else if (i < abrr.length && Math.abs(cdrr[j]) < Math.abs(abrr[i])) {    // abrr[i] 값이 더 큰 경우
                System.out.println("_____ ab");
                i++;
            }
            System.out.println();
        }
        System.out.println(cnt);

    }
}