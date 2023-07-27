package 백준.d0727민준이의계략;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 민준이의계략 {
	static int[] seq, dp;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		seq = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp, 1);
		int answer = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
				answer = Math.max(answer, dp[i]);
			}
		}

		System.out.println(answer);
	}
}
