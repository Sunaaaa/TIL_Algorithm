import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[10];

        int mnum = Integer.parseInt(s)-1;
        String ms = String.valueOf(mnum);
        for (int i = 0; i < ms.length(); i++) {
            cnt[Integer.parseInt(ms.charAt(i)+"")]+=1;
        }
        int max = 0;
        cnt[6] += cnt[9];
        for (int i = 0; i < cnt.length-1; i++) {
            if (i == 6) {
                if (max < (cnt[i]+1)/2) {
                    max = (cnt[i]+1)/2;                    
                }                
            } else {
                if (max < cnt[i]) {
                    max = cnt[i];
                }
            }
        }

        cnt = new int[10];
        
        mnum = Integer.parseInt(s)+1;
        ms = String.valueOf(mnum);
        for (int i = 0; i < ms.length(); i++) {
            cnt[Integer.parseInt(ms.charAt(i)+"")]+=1;
        }
        int max2 = 0;
        cnt[6] += cnt[9];
        for (int i = 0; i < cnt.length-1; i++) {
            if (i == 6) {
                if (max2 < (cnt[i]+1)/2) {
                    max2 = (cnt[i]+1)/2;                    
                }                
            } else {
                if (max2 < cnt[i]) {
                    max2 = cnt[i];
                }
            }
        }

        System.out.println(max<max2?max:max2);
    }

}