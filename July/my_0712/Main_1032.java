import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1032 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        String s = list.get(0);
        list.remove(0);

        for (String str : list) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)!=s.charAt(i)) {
                    s = s.substring(0, i) + '?'+ s.substring(i+1, s.length());
                } else continue;
            }
        }
        System.out.println(s);

    }
}