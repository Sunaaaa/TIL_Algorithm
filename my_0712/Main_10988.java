import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean flag = false;
        for (int i = 0, j = s.length()-1; i < s.length()/2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                flag = true;
                System.out.println(0);
                break;
            }
        }
        if (!flag) {
            System.out.println(1);
        }

    }
}