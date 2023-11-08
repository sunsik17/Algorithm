package 프로그래머스.d1108모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
	final int[] first = {1, 2, 3, 4, 5};
	final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
	final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	public int[] solution(int[] answers) {
		int[] answer;
		int[] count = {0, 0, 0};
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == first[i % first.length]) {
				count[0]++;
			}
			if (answers[i] == second[i % second.length]) {
				count[1]++;
			}
			if (answers[i] == third[i % third.length]) {
				count[2]++;
			}
		}
		int max = -1;
		for (int c : count) {
			if (max < c)  {
				max = c;
			}
		}
		System.out.println(Arrays.toString(count));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (count[i] == max) {
				result.add(i + 1);
			}
		}
		answer = new int[result.size()];
		result.sort((o1, o2) -> o1 - o2);
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] answers = {1, 3, 2, 4, 2};
		System.out.println(Arrays.toString(new 모의고사().solution(answers)));
	}
}
