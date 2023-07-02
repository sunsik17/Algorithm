package 백준.d0701수들의합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {
	static int N, M;
	static int[] nums;
	static int left, right;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		left = 0;
		right = 0;
		int count = 0;
		int sum = nums[left];
		while (right < N && left < N) {
			if (left != right) {
				sum += nums[right];
			}
			if (sum == M) {
				count++;
				left++;
				right = left;
			} else if (sum > M){
				left++;
				right = left;
			} else {
				right++;
				continue;
			}
			if (left < N) {
				sum = nums[left];
			}
		}

		System.out.println(count);
	}
}
