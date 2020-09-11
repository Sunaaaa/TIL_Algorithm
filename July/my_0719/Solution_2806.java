import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2806 {
    static int[][] map;
    static int N, T, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());        
        for (int tc = 1; tc <= T; tc++) {            
            cnt = 0;
            N = Integer.parseInt(br.readLine());        
            map = new int[N][N];        
            back(0,0);
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());

    }

    static public void back(int idx, int count){
        if (idx == N) {
            if (count == N) {
                cnt+=1;
            }
            return;            
        }

        for (int i = 0; i < N; i++) {
            if (isPossible(idx, i) && map[idx][i] == 0) {   // 해당 위치에 놓을 수 있는가/
                map[idx][i] = 1;
                back(idx+1, count+1);          
                map[idx][i] = 0;
            }
        }
    }

    static boolean isPossible(int r, int c){
        for (int i = 0; i < N; i++) {       // 같은 행 탐색
            if (map[r][i] == 1) {   // 같은 행에 이미 하나 있으면?
                return false;                
            }
        }
        for (int i = 0; i < N; i++) {       // 같은 열 탐색
            if (map[i][c] == 1) {   // 같은 열에 이미 하나 있으면?
                return false;
            }
        }
        for (int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--) {       // 대각선 왼위 -> 오아
            if (map[i][j] == 1) {
                return false;
            }
        }
        for (int i = r+1, j = c+1; i < N && j < N; i++, j++) {       // 대각선 왼위 -> 오아
            if (map[i][j] == 1) {
                return false;
            }
        }
        for (int i = r+1, j = c-1; i < N && j >= 0; i++, j--) {       // 대각선 왼아 -> 오위
            if (map[i][j] == 1) {
                return false;
            }
        }
        for (int i = r-1, j = c+1; i >= 0 && j < N; i--, j++) {       // 대각선 왼아 -> 오위
            if (map[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}