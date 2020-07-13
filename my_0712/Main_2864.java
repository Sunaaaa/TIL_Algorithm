import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2864 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String sa = st.nextToken();
        String sb = st.nextToken();
        String a = sa;
        String b = sb;
        for (int i = 0; i < sa.length(); i++) {
            if (sa.charAt(i)==5) {
                a = sa.substring(0, i) + '6' + sa.substring(i+1, sa.length());
            }
        } 
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i)==5) {
                b = sb.substring(0, i) + '6' + sb.substring(i+1, sa.length());
            }
        } 
        System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
        a = sa;
        b = sb;
        for (int i = 0; i < sa.length(); i++) {
            if (a.charAt(i)==6) {
                System.out.println("6 발견");
                a = a.substring(0, i) + '5' + a.substring(i+1, a.length());
            }
        } 
        for (int i = 0; i < sb.length(); i++) {
            if (b.charAt(i)==6) {
                System.out.println("6 발견");
                b = b.substring(0, i) + '5' + b.substring(i+1, b.length());
            }
        } 
        System.out.println(a);
        System.out.println(b);
        System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
    }
}