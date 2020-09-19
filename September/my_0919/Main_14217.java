package my_0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14217 {
	static class Node{
		int n;
		int cnt;
		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	static int[][] map;
	static int N,M;
	static boolean[] visited;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = map[c][r] = 1;
		}

		Queue<Node> queue = null;
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			if (a == 1) {
				map[r][c] = map[c][r] = 1;
			} else map[r][c] = map[c][r] = 0;

			
			sb.append(0);
			boolean[] visited;
			L:for (int j = 1; j < N; j++) {
				sb.append(" ");
				
				queue = new LinkedList<>();
				visited = new boolean[N];
				for (int p = 0; p < N; p++) {
					if (map[j][p] == 1) {
						visited[p] = true;
						queue.offer(new Node(p, 1));
					}
				}

				while (!queue.isEmpty()) {
					Node node = queue.poll();
					int n = node.n;
					int cnt = node.cnt;
					if (n == 0) {
						sb.append(cnt);
						continue L;
					}
					for (int k = 0; k < N; k++) {
						if (k == n) continue;
						if (visited[k]) continue;
						if (map[n][k] != 1) continue;
						visited[k] = true;
						queue.offer(new Node(k, cnt+1));
					}
				}				
				sb.append(-1);
			}
			sb.append("\n");
		} 
		System.out.print(sb.toString());
	}	
}
