package 프로그래머스.d0622요격시스템;

import java.util.Arrays;
class Solution {
	public int solution(int[][] targets) {
		int answer = 0;

		Arrays.sort(targets, (x,y) -> x[1] - y[1]);

		int right = -1;

		for(int[] arr : targets) {
			if (right == -1) {
				answer++;
				right = arr[1] - 1;
				continue;
			}
			if (right >= arr[0] && right <= arr[1]) continue;

			answer++;
			right = arr[1] - 1;
		}

		return answer;
	}

	public static void main(String[] args) {

		int[][] targets = {
			{4, 5},
			{4, 8},
			{10, 14},
			{11, 13},
			{5, 12},
			{3, 7},
			{1, 4},
		};
		System.out.println(new Solution().solution(targets));
	}
}
