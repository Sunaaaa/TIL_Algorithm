import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
    static int R, C, H, cnt, ck;
    static int[][][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<Node>();
        // boolean[][] visited = new boolean[R][C];
        cnt = 0;
        ck = 0;

        map = new int[R][C][H];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < R; i++) {
                st = new  StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    if (map[i][j][h] == 1) {   // 익은 토마토 담기
                        queue.offer(new Node(i, j, h));
                    } else if (map[i][j][h] == 0) {
                        ck+=1;
                    }                    
                }
            }          
              
        }

        if (ck == 0) {
            System.out.println(0);
        } else {   
            while (true){
                int size = queue.size();
                if (size == 0) break;
                else {
                    while (size-- > 0) {
                        Node n = queue.poll();
                        int r = n.r;
                        int c = n.c;
                        int h = n.h;
                        
                        // 4방 탐색
                        L:for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];                        
                            int nc = c + dc[k];
                            if (!check(nr, nc, h)) continue L;
                            // if (visited[nr][nc]) continue L;
                            if (map[nr][nc][h]==0) {
                                map[nr][nc][h] = 1;
                                // visited[nr][nc] = true;
                                queue.offer(new Node(nr, nc, h));
                                ck--;
                            }
                        }
                        // 위 아래
                        Z:for (int p = 0; p < 2; p++) {
                            int nh = h + dz[p];
                            if (!check(r, c, nh)) continue Z;
                            if (map[r][c][nh]==0) {
                                map[r][c][nh] = 1;
                                queue.offer(new Node(r,c,nh));
                                ck--;
                            }
                        }
                    }
                    cnt += 1;
                }
            }
            System.out.println(ck==0?cnt-1:-1);
        }
    }
    static int[] dz = {1,-1};
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static boolean check(int r, int c, int h){
        return r >= 0 && c >= 0 && r < R && c < C && h < H && h >= 0;
    }

    static class Node {
        int r;
        int c;
        int h;

        public Node(int r, int c, int h){
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
}