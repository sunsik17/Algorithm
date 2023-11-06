package 프로그래머스.d1106월간고사.solution1;

import java.util.Arrays;

public class Solution {
	public int solution(int N, int[] selected, int[][] lottos) {
		int answer = 0;
		Arrays.sort(selected);
		final String myLotto = Arrays.toString(selected);
		for (int[] lotto : lottos) {
			Arrays.sort(lotto);
			if (Arrays.toString(lotto).equals(myLotto)) answer++;
		}
		return answer;
	}
}
