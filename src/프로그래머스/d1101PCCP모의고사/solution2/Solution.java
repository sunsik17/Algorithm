package 프로그래머스.d1101PCCP모의고사.solution2;

import java.util.PriorityQueue;

public class Solution {

	PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
	public int solution(int[] ability, int number) {
		int answer = 0;
		for (int i : ability) {
			pq.add(i);
		}
		for (int i = 0; i < number; i++) {
			int a = pq.poll();
			int b = pq.poll();
			int tmp = a + b;
			pq.add(tmp);
			pq.add(tmp);
		}
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		return answer;
	}

}
