package my_0920;

public class KMP {
	public static void main(String[] args) {
		my_KMP("asdasdasdasddkghusaasdasd", "asd");
	}
	static int[] getPi(String pat) {
		int[] p = new int[pat.length()];
		int j = 0;
		for (int i = 1; i < p.length; i++) {
			while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
				j = p[j-1];
			}
			if (pat.charAt(i)==pat.charAt(j)) {
				p[i] = ++j;
			}
		}
		
		return p;
	}
	static void my_KMP(String origin, String pattern) {
		int cnt = 0;
		int[] p = getPi(pattern);
		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = p[j-1];
			}
			if (origin.charAt(i)==pattern.charAt(j)) {
				if (j == pattern.length()-1) {	// 문장 내 패턴과 일치하는 단어 발견
					cnt+=1 ;
					System.out.println(pattern + cnt + "개 발견");
					j = p[j];
				} else {
					j++;					
				}
			}
		}
		
	}
}
