package my_0831;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	SWExpert 7793. 오! 나의 여신님 
	- BFS + 시뮬레이션
	- 수연 & 악마 2개의 큐로 나누지 않고, 1개의 큐로 구현
	- 악마는 list에 담고, 큐에는 수연이 -> 악마들 순으로 넣는다.
	- 악마 : S 또는 .
	  수연 : D 또는 . 
	- 처음 큐의 크기만큼 BFS
	  -> 수연이 & 악마들이 움직임 
	  
*/
public class Solution {
    static int N, M, min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static char[][] map;
	static boolean[][] visited;
	static int Sr, Sc, Er, Ec;

	static class Node {
		int r;
		int c;
		int dist;

		public Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.dist = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;

			map = new char[N][M];
			visited = new boolean[N][M];

			Queue<Node> queue = new LinkedList<Node>();
			ArrayList<Node> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				char c = '.';
				for (int j = 0; j < M; j++) {
					c = map[i][j] = s.charAt(j);
					if (c == 'S') { // 수연
						Sr = i;
						Sc = j;
					} else if (c == '*') {
						list.add(new Node(i, j, 0));
					}
				}
			}

			// 수연 S, 여신 D, 악마 *, 돌 X
			queue.offer(new Node(Sr, Sc, 0));
			for (Node node : list) {
				queue.offer(node);
			}

			L: while (!queue.isEmpty()) {
				int size = queue.size();
				while (size-- > 0) {
					Node n = queue.poll();
					int r = n.r;
					int c = n.c;

					if (map[r][c] == 'D') { // 여신일 경우, 끝
						min = Math.min(n.dist, min);
						break L;
					}

					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						
						if (!isIn(nr, nc)) continue;
						if (!visited[nr][nc]) {
							if (map[r][c] == '*' && (map[nr][nc] == '.' || map[nr][nc] == 'S')) {	// 악마
								map[nr][nc] = '*';
								visited[nr][nc] = false;
								queue.offer(new Node(nr, nc, n.dist+1));
							} else if (map[r][c] == 'S' && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {	// 수연
								if (map[nr][nc] == '.') {
									map[nr][nc] = 'S';									
								}
								visited[nr][nc] = false;
								queue.offer(new Node(nr, nc, n.dist+1));
							}
						}
						
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(min==Integer.MAX_VALUE?"GAME OVER":min).append("\n");

		}
		System.out.print(sb.toString());

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}