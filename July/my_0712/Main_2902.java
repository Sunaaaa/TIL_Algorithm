import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2902 {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split("-");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].charAt(0));
        }
        // System.out.println();
    }
}