package 프로그래머스.d1101PCCP모의고사.solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int solution(int[] menu, int[] order, int k) {
		int answer = 0;
		List<int[]> waiting = new ArrayList<>();
		int wait = 0;
		for (int i = 0; i < order.length; i++) {
			int cur = i * k;
			waiting.add(new int[]{cur, wait + menu[order[i]] + cur});
			wait = k - (menu[order[i]] + wait);
			if (wait >= 0) {
				wait = 0;
			} else {
				wait *= -1;
			}
		}
		System.out.println(Arrays.deepToString(waiting.toArray()));
		for (int i = 0; i < waiting.size(); i++) {
			int[] tmp = waiting.get(i);
			int max = 1;
			for (int j = i + 1; j < waiting.size(); j++) {
				if (tmp[1] > waiting.get(j)[0]) {
					max++;
					if (j == waiting.size() - 1) {
						answer = Math.max(max, answer);
					}
				} else {
					answer = Math.max(max, answer);
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] menu = {3, 2, 4, 1};
		int[] order = {0, 1, 2, 3, 0, 1, 2, 3};
		int k = 5;

		System.out.println(new Solution().solution(menu, order, k));
	}
}