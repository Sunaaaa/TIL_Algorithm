public class Solution_1493 {
    static int[][] map;
    public static void main(String[] args) {
        map = new int[10][10];
        
        int num = 1;
        for (int c = 0; c < map.length; c++) {
            System.out.println("c : "+c);
            for (int r = 0, k = c; k >= 0 && r < c; r++, k--) {
                System.out.print(k+" ");
                if (c == 0 && k == 0) {
                    System.out.println("있는데..?");
                }
                map[r][k] = num++;                
            }

        }        

        System.out.println("---");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}