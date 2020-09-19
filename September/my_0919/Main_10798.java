package my_0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10798 {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		map = new char[5][15];
		int maxLength = 0;
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			maxLength = Math.max(s.length(), maxLength);
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[j][i]!='\u0000') {
					sb.append(map[j][i]);
				}
			}
		}
		System.out.print(sb.toString());
		
	}
}
