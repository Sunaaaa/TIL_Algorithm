import java.io.BufferedReader;
import java.io.InputStreamReader;

public class aaaa {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i <= data; i++) {
            if (i%3==0 || i%5 ==0) {
                sum += i;                            
            }
        }
        System.out.println(sum);
    }
}