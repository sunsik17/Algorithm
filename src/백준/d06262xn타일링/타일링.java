package 백준.d06262xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링 {

	static int[] dp;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = ((dp[i - 2] * 2) + dp[i - 1] % 10007);
		}
		System.out.println(dp[n]);
	}

}
