package my_0920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	static int N, M, H, totalCnt;
	static int[][][] box;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 익은 토마토
		Queue<Tomato> queue = new LinkedList<Tomato>();
		visited = new boolean[N][M][H];
		box = new int[N][M][H];
		for (int h = 0; h < H; h++) {			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					int num = Integer.parseInt(st.nextToken());
					box[r][c][h] = num;
					if (num == 0) {
						totalCnt += 1;
					} else if (num == 1) {
						queue.offer(new Tomato(r, c, h));
					}
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
				int r = t.r;
				int c = t.c;
				int h = t.h;
				for (int k = 0; k < dr.length; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if (isIn(nr, nc, h) && box[nr][nc][h] == 0) {
						box[nr][nc][h] = 1;
						totalCnt-=1;
						queue.offer(new Tomato(nr, nc, h));
					}
				}
				for (int k = 0; k < 2; k++) {
					int nh = t.h + dr[k];
					if (isIn(r, c, nh) && box[r][c][nh]==0) {
						box[r][c][nh] = 1;
						totalCnt-=1;
						queue.offer(new Tomato(r, c, nh));
					}
				}
			}
			ans += 1;
		}
		
		// totalCnt == 0이면 모두 익은 경우, totalCnt != 0 이면 모두 익지 못함
		System.out.println(totalCnt==0?ans:-1);
		
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	private static boolean isIn(int r, int c, int h) {
		return r >= 0 && c >= 0 && h >= 0 && r < N && c < M && h < H;
	}
	
	private static class Tomato{
		int r;
		int c;
		int h;
		public Tomato(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
		@Override
		public String toString() {
			return "("+r+","+c+"/"+h+")";
		}
	}
}
