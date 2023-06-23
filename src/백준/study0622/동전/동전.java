package 백준.study0622.동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전 {

	static int n, k;
	static int[] dp;
	static List<Integer> coins = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[k + 1];
		dp[0] = 1;

		while(n-- > 0) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		countCoinChange();

		System.out.println(dp[k]);
	}
	private static void countCoinChange() {
		for (int coin : coins) {
			for (int i = coin; i < k + 1; i++) {
				dp[i] += dp[i - coin];
			}
		}
	}

}
