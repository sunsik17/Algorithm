package 백준.d0927합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합구하기 {

	static int N, M;
	static int[] nums, sum;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		sum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				sum[i] = nums[i] + sum[i - 1];
			} else sum[i] = nums[i];
		}

		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(sum[j - 1] - (i == 1 ? 0 : sum[i - 2])).append('\n');
		}

		System.out.println(sb);
	}

}
