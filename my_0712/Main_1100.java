import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1100 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int idx = i%2;
            String s = br.readLine();
            for (int j = idx; j < 8; j+=2) {
                if (s.charAt(j)=='F'){
                    cnt+=1;
                }
            }
        }        
        System.out.println(cnt);
    }
}