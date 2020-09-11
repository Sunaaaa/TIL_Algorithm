import java.util.Scanner;

public class Main_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int nx = w-x;
        int ny = h-y;

        int tn = nx < ny?nx:ny;
        int t = x < y?x:y;

        System.out.println(tn<t?tn:t);
    }
}