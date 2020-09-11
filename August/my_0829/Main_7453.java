import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7453 {

    static int[] arr,brr,crr,drr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        brr = new int[N];
        crr = new int[N];
        drr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
            crr[i] = Integer.parseInt(st.nextToken());
            drr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++){
                    for (int p = 0; p < N; p++){
                        if (arr[i] + brr[j] + crr[k] + drr[p]==0) {
                            cnt +=1 ;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);


    }
}