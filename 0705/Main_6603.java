import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {

    static int[] arr, result;
    static int k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            result = new int[6];

            if ( k == 0 ) {     // 0 인 경우, 테스트 케이스 끝 -> 정답 출력
                System.out.println(sb.toString());
                return;                
            } else {            // 배열 만들어서 조합 진행
                for (int i = 0; i < k; i++) {       // 배열 만들기
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                // 조합 
                comb(0,0);
                sb.append("\n");
            }
        }
    }

    static void comb(int idx, int cdx){
        if (cdx == result.length) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append("\n");
            return;            
        }
        if (idx == arr.length) return;

        result[cdx] = arr[idx];
        comb(idx+1, cdx+1);
        comb(idx+1, cdx);
    }
}