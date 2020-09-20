package my_0920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	static int N, M, totalCnt;
	static int[][] box;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 익은 토마토
		Queue<Tomato> queue = new LinkedList<Tomato>();
		visited = new boolean[N][M];
		box = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int num = Integer.parseInt(st.nextToken());
				box[r][c] = num;
				if (num == 0) {
					totalCnt += 1;
				} else if (num == 1) {
					queue.offer(new Tomato(r, c, 0));
				}
			}
		}
		
		int ans = 0;
		// 토마토 익히기
		L:while (true) {
			if (totalCnt<=0 || queue.isEmpty()) {
				break L;
			}
			int size = queue.size();
			while (size-- > 0) {
				Tomato t = queue.poll();
				for (int k = 0; k < dr.length; k++) {
					int nr = t.r + dr[k];
					int nc = t.c + dc[k];
					if (isIn(nr, nc) && box[nr][nc] == 0) {
						box[nr][nc] = 1;
						totalCnt-=1;
						queue.offer(new Tomato(nr, nc, t.cnt+1));
					}
				}
			}
			ans += 1;
		}
		
		// totalCnt == 0이면 모두 익은 경우, totalCnt != 0 이면 모두 익지 못함
		System.out.println(totalCnt==0?ans:-1);
		
	}

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	private static class Tomato{
		int r;
		int c;
		int cnt;
		public Tomato(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "("+r+","+c+")";
		}
	}
}
