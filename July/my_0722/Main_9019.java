import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {

    static Queue<Node> queue;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sbs = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            visited = new boolean[10000];

            queue.offer(new Node(s,""));
            L:while (true) {
                Node node = queue.poll();
                if (node.str==result) {
                    sbs.append(node.sb).append("\n");
                    break L;
                }

                int n = node.str;
                String sb = node.sb;

                // D
                if (n*2 > 9999) {
                    int c = (n*2)%10000;
                    if (!visited[c]) {
                        visited[c] = true;
                        queue.offer(new Node(c, sb+'D'));
                    }
                } else {
                    if (!visited[n*2]) {
                        visited[n*2] = true;
                        queue.offer(new Node(n*2,  sb+'D'));            
                    }
                }
        
                // S
                if (n == 0) {
                    if (!visited[9999]) {
                        visited[9999] = true;
                        queue.offer(new Node(9999,  sb+'S'));                        
                    }
                } else {
                    if (!visited[n-1]) {
                        visited[n-1] = true;                        
                        queue.offer(new Node(n-1,  sb+'S'));
                    }
                }

                // L 1234-> 2341 -> 3412
                int ls = ((n%1000)*10)+(n/1000);
                if (!visited[ls]){
                    visited[ls] = true;
                    queue.offer(new Node(ls, sb+"L"));
                }

                // R 1234 -> 4123 -> 3412
                int rs = (n/10)+((n%10)*1000);
                if (!visited[rs]){
                    visited[rs] = true;
                    queue.offer(new Node(rs,  sb+"R"));
                }

            }
        }
        System.out.print(sbs.toString());

    }

    static class Node{
        int str;
        String sb;

        public Node(int str, String c){
            this.str = str;
            sb = c;
        }
    }

}