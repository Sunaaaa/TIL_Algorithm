package my_0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		L:for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c=='(') {
					stack.push('(');
				} else {
					if (stack.isEmpty()) {
						sb.append("NO").append("\n");
						continue L;
					} else stack.pop();
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			} else sb.append("NO").append("\n");
		}
		System.out.print(sb.toString());
	}
}
