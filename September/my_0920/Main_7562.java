package my_0920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
	static int[][] map;
	static boolean[][] visited;
	static int N, Dr, Dc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());			
			map = new int[N][N];
			visited = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine()); // 현재 위치
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());	// 도착지
			int Dr = Integer.parseInt(st.nextToken());
			int Dc = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			boolean isDes = false; // 도착지 도착 or 큐가 비어있음
			Queue<Chess> queue = new LinkedList<Chess>();
			queue.offer(new Chess(r, c, 0));
			
			L:while (!queue.isEmpty()) {
				Chess chess = queue.poll();
				if (chess.r == Dr && chess.c == Dc) {
					isDes = true;
					ans = chess.cnt;
					break L;
				}
				for (int k = 0; k < dr.length; k++) {
					int nr = chess.r + dr[k];
					int nc = chess.c + dc[k];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new Chess(nr, nc, chess.cnt+1));
					}
				}
				
			}
			
			sb.append(isDes?ans:-1).append("\n");
		}
		System.out.print(sb.toString());
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	static int[] dr = {-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {1,2,2,1,-1,-2,-2,-1};
	static class Chess{
		int r;
		int c;
		int cnt;
		public Chess(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
