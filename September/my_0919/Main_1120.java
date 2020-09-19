package my_0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String atr = st.nextToken();
		String btr = st.nextToken();
		int len = btr.length()-atr.length()+1;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < len; i++) {			
			int cnt = 0;
			for (int j = 0; j < atr.length(); j++) {
				if (atr.charAt(j)!=btr.charAt(j+i)) {
					cnt += 1;
				}
			}
			ans = Math.min(ans, cnt);
		}
		System.out.println(ans);
		
	}
}
