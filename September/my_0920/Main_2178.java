package my_0920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(0, 0, 1));
		visited[0][0] = true;

		L: while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.r == N - 1 && n.c == M - 1) {
				System.out.println(n.cnt);
				break L;
			}
			for (int k = 0; k < 4; k++) {
				int nr = n.r + dr[k];
				int nc = n.c + dc[k];
				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new Node(nr, nc, n.cnt + 1));
				}
			}
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	private static class Node {
		int r;
		int c;
		int cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
