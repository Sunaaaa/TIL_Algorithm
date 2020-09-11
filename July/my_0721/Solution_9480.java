import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_9480 {
    static Map<String, Integer> map;
    static Map<Integer, String> map2 = new HashMap<Integer, String>(){{
        put(0, "ZRO");
        put(1, "ONE");
        put(2, "TWO");
        put(3, "THR");
        put(4, "FOR");
        put(5, "FIV");
        put(6, "SIX");
        put(7, "SVN");
        put(8, "EGT");
        put(9, "NIN");
    }};
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        map = new HashMap<>();

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String tcc = sc.next();
            sb.append(tcc).append("\n");
            int N = sc.nextInt();
            map.clear();
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String key = sc.next();
                System.out.println(key);
                if (map.containsKey(key)){
                    map.put(key, map.get(key)+1);
                } else map.put(key, 1);
            }

            for (String str : map.keySet()){
                int t = map.get(str);
                switch (str) {
                    case "ZRO":
                        for (int i = 0; i < t; i++) {
                            list.add(0);
                        }
                        break;
                    case "ONE":
                        for (int i = 0; i < t; i++) {
                            list.add(1);
                        }
                        break;
                    case "TWO":
                        for (int i = 0; i < t; i++) {
                            list.add(2);
                        }
                        break;
                    case "THR":
                        for (int i = 0; i < t; i++) {
                            list.add(3);
                        }
                        break;
                    case "FOR":
                        for (int i = 0; i < t; i++) {
                            list.add(4);
                        }
                        break;
                    case "FIV":
                        for (int i = 0; i < t; i++) {
                            list.add(5);
                        }
                        break;                    
                    case "SIX":
                        for (int i = 0; i < t; i++) {
                            list.add(6);
                        }
                        break;
                    case "SVN":
                        for (int i = 0; i < t; i++) {
                            list.add(7);
                        }
                        break;
                    case "EGT":
                        for (int i = 0; i < t; i++) {
                            list.add(8);
                        }
                        break;
                    case "NIN":
                        for (int i = 0; i < t; i++) {
                            list.add(9);
                        }
                        break;
                }                
            }

            Collections.sort(list);
            for (Integer num : list) {
                sb.append(map2.get(num)).append(" ");
            }
            sb.append("\n");            
        }
        System.out.print(sb.toString());
    }
}