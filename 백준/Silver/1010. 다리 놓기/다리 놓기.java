import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] n = new int[t];
        int[] r = new int[t];

        int[][] dp = new int[31][31];
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            n[i] = y;
            r[i] = x;
        }
        dp[1][1] = 1;
        dp[1][0] = 1;

        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(dp[n[i]][r[i]]);
        }
    }
}