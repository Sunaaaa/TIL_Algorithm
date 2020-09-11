import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, s.length());
            map.put(str, str);
        }

        for (String string : map.keySet()) {
            System.out.println(string);
        }
        
    }
}