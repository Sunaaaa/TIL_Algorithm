package my_0831;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_GoodMorning_0831 {
	static int[] arr, result;
	static boolean[] visited;
	static int N, M, v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		v = 0;
		
		// N 개 중 M 개 선택
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));
		
//		perm(0);
//		permDup(0);
//		comb(0,0);
		combDup(0,0);
		
	}
	private static void combDup(int i, int j) {
		if (j == M) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		if (i == N) return;
		
		result[j] = arr[i];
		combDup(i, j+1);
		combDup(i+1, j);
		
	}
	private static void comb(int i, int j) {
		if (j == M) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		if (i == N) return;
		
		result[j] = arr[i];
		comb(i+1, j+1);
		comb(i+1, j);
	}
	private static void permDup(int i) {
		if (i == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int j = 0; j < N; j++) {
			result[i] = arr[j];
			permDup(i+1);
		}
	}
	private static void perm(int i) {
		if (i == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int j = 0; j < N; j++) {
			if ((v & (1<<j))==0) {
				v |= (1<<j);
				result[i] = arr[j];
				perm(i+1);
				v &= ~(1<<j);
			}
		}
	}    
}