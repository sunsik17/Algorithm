package 백준.study0622.숫자1로만들기;

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
			if (i % 3 == 0 || i % 2== 0) {
				int count = 0;
				int count2;
				if (i % 3 == 0) {
					count = dp[i / 3] + 1;
					dp[i] = Math.min(count, dp[i - 1] + 1);
				}
				if (i % 2 == 0){
					count2 = dp[i / 2] + 1;
					if (count == 0) {
						dp[i] = Math.min(count2, dp[i - 1] + 1);
					} else {
						dp[i] = Math.min(count, count2);
					}
				}
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		System.out.println(dp[k]);
	}

}