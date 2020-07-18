import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main_1339 {
    static int N, R, v, max = 0;
    static int[] arr,result;

    static Set<Character> set;
    static ArrayList<String> list;
    static ArrayList<Character> alphalist;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 

        set = new HashSet<>();        
        list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(s);    
            for (int j = 0; j < s.length(); j++) {
                char e = s.charAt(j);
                set.add(e);
            }
        }
        
        map = new HashMap<>();
        int idx = 0;
        for (Character ch : set) {
            map.put(ch, idx++);
        }

        R = set.size();
        arr = new int[R];
        result = new int[R];

        for (int i = 9, k = 0; k < R; i--, k++) {
            arr[k] = i;            
        }
        v = 0;

        resolve(0);
        System.out.println(max);
    }

    static public void resolve(int idx){
        if (idx == R) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);            
                int ttmp = 0;
                int tidx = 1;
                for (int j = s.length()-1; j >=0; j--) {
                    ttmp += result[map.get(s.charAt(j))]*tidx;
                    tidx*=10;
                }
                sum += ttmp;
            }
    
            if (max < sum) {
                max = sum;
            }
            return;
        }        

        for (int i = 0; i < arr.length; i++) {
            if ((v & (1<<i))==0) {  // 미 방문
                v |= (1<<i);
                result[idx] = arr[i];
                resolve(idx+1);
                v &= ~(1<<i);
            }
        }
    }
}

