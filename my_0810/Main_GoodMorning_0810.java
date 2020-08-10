import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_GoodMorning_0810 {
   static int N, R;
   static int[] arr, result;
   static boolean[] visited;
   static int v;
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      
      v = 0;
      arr = new int[N];
      result = new int[R];
      visited = new boolean[N];
      
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }
      
//      perm(0);
//      permDup(0);
//      comb(0,0);
//      combDup(0,0);
      
   }
   
   static void perm(int idx) {
      if (idx == R) {
         System.out.println(Arrays.toString(result));
         return;
      }
      for (int i = 0; i < arr.length; i++) {
         if ((v & (1<<i))==0) {
            v |= (1<<i);
            result[idx] = arr[i];
            perm(idx+1);
            v &= ~(1<<i);
         }
      }
   }
   
   static void permDup(int idx) {
      if (idx == R) {
         System.out.println(Arrays.toString(result));
         return;
      }
      for (int i = 0; i < arr.length; i++) {
         result[idx] = arr[i];
         permDup(idx+1);
      }
   }
   
   static void comb(int idx, int cdx) {
      if (cdx == R) {
         System.out.println(Arrays.toString(result));
         return;
      }
      if (idx == N) return;
      
      result[cdx] = arr[idx];
      comb(idx+1, cdx+1);
      comb(idx+1, cdx);
   }

   static void combDup(int idx, int cdx) {
      if (cdx == R) {
         System.out.println(Arrays.toString(result));
         return;
      }
      if (idx == N) return;
      
      result[cdx] = arr[idx];
      combDup(idx, cdx+1);
      combDup(idx+1, cdx);
   }


}