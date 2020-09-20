package my_0920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
	static char[][] map;
	static boolean [][] visited;
	static int[] dist;
	static ArrayList<Integer> list;
	static int N, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		dist = new int[N*N/2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		list = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == '1' && !visited[r][c]) {
					visited[r][c] = true;
					
					cnt = 1;
					queue.offer(new Node(r, c));
					while (!queue.isEmpty()) {
						Node n = queue.poll();
						
						for (int k = 0; k < 4; k++) {
							int nr = n.r + dr[k];
							int nc = n.c + dc[k];
							if (isIn(nr, nc) && map[nr][nc] == '1' && !visited[nr][nc]) {
								cnt += 1;
								visited[nr][nc] = true;
								queue.offer(new Node(nr, nc));
							}
						}
						
					}
					list.add(cnt);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for (Integer num : list) {
			System.out.println(num);
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N; 
	}
	private static class Node{
		int r;
		int c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
