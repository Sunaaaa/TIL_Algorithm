package my_0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 소문자, 소문자
			if (c <= 'z' && c >= 'a') {
				char cc = (char) (c + 13);
				if (c + 13 > 122 || c + 13 < 97) {
					cc = (char) (cc - 26);
				}
				sb.append(cc);
			} else if (c <= 'Z' && c >= 'A') {
				char cc = (char) (c + 13);
				if (c + 13 > 90 || c + 13 < 65) {
					cc = (char) (cc - 26);
				}
				sb.append(cc);
			} else {
				sb.append(c);
			}
		}
		System.out.print(sb.toString());
	}
}
