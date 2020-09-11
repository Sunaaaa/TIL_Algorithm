import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10808 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c = (int)s.charAt(i)-97;
            cnt[c] += 1;
        }

        for (int i = 0; i < cnt.length; i++) {
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}