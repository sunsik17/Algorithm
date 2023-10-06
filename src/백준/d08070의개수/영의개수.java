package 백준.d08070의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영의개수 {

	static int[] dp;
	static int T, N, M;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dp = new int[10000001];
		dp[0] = 1;
		for (int i = 1; i <= 1_000_000; i++) {
			String num = String.valueOf(i);
			int count = 0;
			for (int j = 0; j < num.length(); j++) {
				if (num.charAt(j) == '0') {
					count++;
				}
			}
			dp[i] = dp[i - 1] + count;
		}
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int i = N; i <= M; i++) {
				String num = String.valueOf(i);
				if (num.charAt(i) == '0') {
					count++;
				}
			}
			sb.append(dp[M] - dp[N] + count).append('\n');
		}
		System.out.println(sb);
	}
}
