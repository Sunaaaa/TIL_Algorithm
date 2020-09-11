import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {

    static int N, v;
    static int[] arr;   // 숫자
    static char[] op, result;   // 연산자
    static int max_cnt, min_cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = 0;
        N = Integer.parseInt(br.readLine());

        min_cnt = Integer.MAX_VALUE;
        max_cnt = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int c = 0;
        op = new char[N-1];
        result = new char[N-1];
       
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t == 0) continue;
            char ch = ' ';
            switch (i) {
                case 0:
                    ch = '+';                    
                    break;
                case 1:
                    ch = '-';                    
                    break;
                case 2:
                    ch = '*';                    
                    break;
                case 3:
                    ch = '/';                    
                    break;
            }

            for (int j = 0; j < t; j++) {
                op[c++] = ch;                
            }
        }   // arr, op 배열 초기화 끝

        // 순열 
        perm(0);
        System.out.println(max_cnt);
        System.out.println(min_cnt);

    }

    static void perm(int idx){
        if (idx == result.length) {
            // 계산
            calc();
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if ((v&(1<<i))==0) {    // 방문 안했을 경우
                     v |= (1<<i);
                     result[idx] = op[i];
                     perm(idx+1);
                     v &= ~(1<<i);                
            }
        }
    }

    static void calc(){
        int res = arr[0];
        for (int i = 0; i < result.length; i++) {
            int a = arr[i+1];
            switch (result[i]) {
                case '+':
                    res += a;                                     
                    break;
                case '-':
                    res -= a;                                     
                    break;
                case '*':
                    res *= a;                                     
                    break;
                case '/':
                    res = res / a;                                     
                    break;
            }                            
        }
        if (max_cnt < res) {
            max_cnt = res;            
        }
        if (min_cnt > res) {
            min_cnt = res;            
        }
    }
}