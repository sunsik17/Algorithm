package 백준.d1007두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
	static int n, x;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		x = Integer.parseInt(br.readLine());
		int answer = 0;

		int left = 0;
		int right = n - 1;
		int start = 0;
		boolean[] visited = new boolean[n];

		while (left < right) {
			int c = nums[left] + nums[right];
			if (c > x) {
				right--;
			} else if (c < x) {
				left++;
			} else {
				if (!visited[left]) {
					answer++;
					visited[left] = true;
					left = ++start;
					right = n - 1;
				} else {
					left = ++start;
					right = n - 1;
				}
			}
		}
		System.out.println(answer);
	}
}