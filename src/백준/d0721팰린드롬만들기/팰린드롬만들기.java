package 백준.d0721팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 팰린드롬만들기 {

	static int N;
	static int[][] dp;
	static int[] nums;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solution(0, N - 1));
	}

	static int solution(int left, int right) {
		if (left >= right) return 0;
		if (dp[left][right] != -1) return dp[left][right];

		int min = 0;
		if (nums[left] == nums[right]) {
			min = solution(left + 1, right - 1);
		} else {
			min = Math.min(solution(left + 1, right) + 1, solution(left, right - 1) + 1);
		}
		dp[left][right] = min;
		return min;
	}

}
