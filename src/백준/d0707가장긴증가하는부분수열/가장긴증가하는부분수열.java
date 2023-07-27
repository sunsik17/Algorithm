package 백준.d0707가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

	static int[] dp, A;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N];
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 1;
		Arrays.fill(dp, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			answer = Math.max(dp[i], answer);
		}

		System.out.println(answer);
	}
}
