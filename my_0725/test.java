import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// StringTokenizer 구분자 여러개
public class test {
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(),"!| |?");

        for (int i = 0; i < 20; i++) {
            System.out.println(st.nextToken());
        }

    }
}