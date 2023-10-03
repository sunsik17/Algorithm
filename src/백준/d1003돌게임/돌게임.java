import java.util.Scanner;

class 돌게임 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        String[] dp = new String[N + 1];
        
        dp[1] = "SK";
        
        for (int i = 2; i <= N; i++) {
            if(dp[i - 1].equals("SK")) {
                dp[i] = "CY";
            } else {
                dp[i] = "SK";
            }
        }
        
        System.out.print(dp[N]);
    }
}
