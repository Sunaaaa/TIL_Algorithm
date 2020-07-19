import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_5948 {
    static int[] arr, result;
    static Set<Integer> set;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =  null;
        set = new HashSet<Integer>();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            arr = new int[7];
            result = new int[3];    
            set.clear();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(0,0);
            list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());
            sb.append("#").append(tc).append(" ").append(list.get(4)).append("\n");
        }

        System.out.println(sb.toString());

    }

    static public void comb(int cdx, int idx){
        if (cdx == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += result[i];                
            }
            set.add(sum);
            return;           
        }
        if (idx == 7) return;

        result[cdx] = arr[idx];
        comb(cdx+1, idx+1);
        comb(cdx, idx+1);
    }
}