package 백준.d06271_2_3더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_2_3더하기 {
    static int[] dp;
    static int T, n;
    static int[] nums = {1, 2, 3};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            dp = new int[n + 1];
            dp[0] = 1;

            for(int num : nums) {
                for(int i = num; i <= n; i++) {
                    dp[i] += dp[i - num];
                }
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
