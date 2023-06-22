package BJ.study0622.makeNumber1;

import java.util.Scanner;

public class Main {

	static int[] dp;
	static int k;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();

		if (k == 1) {
			System.out.println(0);
			return;
		} else if (k < 4) {
			System.out.println(1);
			return;
		}
		dp = new int[k + 1];

		dp[1] = 0;

		for (int i = 2; i < k + 1; i++) {
			if (i % 3 == 0) {
				int count = dp[i / 3] + 1;
				dp[i] = Math.min(count, dp[i - 1] + 1);
			} else if (i % 2 != 0) {
				dp[i] = dp[i - 1] + 1;
				continue;
			}
			if (i % 2 == 0) {
				int count = dp[i / 2] + 1;
				dp[i] = Math.min(count, dp[i - 1] + 1);
			}
		}

		System.out.println(dp[k]);
	}

}