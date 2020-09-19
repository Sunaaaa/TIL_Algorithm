package my_0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12761 {
	static int N, M, A, B, ans;
	static int[] dr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		dr = new int[] {1,-1,A,-A,B,-B,};
		ans = Integer.MAX_VALUE;
		
		// 0 : 위치 , 1 : 이동 횟수
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {N,0});
		visited[N] = true;
		
		L:while (!queue.isEmpty()) {			
			int[] arr = queue.poll();
			int r = arr[0];
			int cnt = arr[1];
			if (r == M) {
				ans = Math.min(cnt, ans);
				break L;
			}
			
			int nr = 0;
			for (int k = 0; k < dr.length; k++) {
				nr = r + dr[k];
				if (isIn(nr) && !visited[nr]) {	// 돌다리 안에 있으며 아직 방문하지 않은 경우
					visited[nr] = true;
					queue.offer(new int[] {nr, cnt+1});
				}
			}

			// A배
			nr = r * A;
			if (isIn(nr) && !visited[nr]) {	// 돌다리 안에 있으며 아직 방문하지 않은 경우
				visited[nr] = true;
				queue.offer(new int[] {nr, cnt+1});
			}				
		
			// B배 좌우
			nr = r * B;
			if (isIn(nr) && !visited[nr]) {	// 돌다리 안에 있으며 아직 방문하지 않은 경우
				visited[nr] = true;
				queue.offer(new int[] {nr, cnt+1});
			}
			
		}
		System.out.println(ans);
		
		
	}
	private static boolean isIn(int r) {
		return r >= 0 && r <= 100000;
	}
	
}
