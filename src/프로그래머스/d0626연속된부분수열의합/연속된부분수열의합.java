package 프로그래머스.d0626연속된부분수열의합;

import java.util.Arrays;

public class 연속된부분수열의합 {
	public int[] solution(int[] sequence, int k) {
		int len = sequence.length;
		int left = 0;
		int right = len - 1;
		int sum = 0;
		int j = 0;
		for (int i = 0; i < len; i++) {
			while (j < len && sum < k) {
				sum += sequence[j++];
			}
			if (sum == k) {
				int r = j - i - 1;
				if ((right - left) > r) {
					left = i;
					right = j - 1;
				}
			}
			sum -= sequence[i];
		}
		return new int[]{left, right};
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 연속된부분수열의합().solution(new int[]{2, 2, 2, 2, 2}, 6)));
	}
}
