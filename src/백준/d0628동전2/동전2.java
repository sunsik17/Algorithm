package 백준.d0628동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 동전2 {
	static List<Integer> coins = new ArrayList<>();
	static int n, k;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		coins.sort((x,y) -> x - y);
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		changeCoin();
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[k]);
	}
	private static void changeCoin() {
		for (int coin : coins) {
			for (int i = coin; i <= k; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
	}
}