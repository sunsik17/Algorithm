package 백준.d240326조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 조합 {
	static int n, m;
	static BigInteger[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new BigInteger[n + 1][n + 1];
		dp[0][0] = BigInteger.ONE;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) dp[i][j] = BigInteger.ONE;
				else {
					dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[n][m]);
	}

}
