package 프로그래머스.d240122프로세스;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class 프로세스 {

	Queue<Process> q = new LinkedList<>();
	PriorityQueue<Process> pq = new PriorityQueue<>((x, y) -> y.priority - x.priority);

	static class Process {

		int idx;
		int priority;

		public Process(int i, int p) {
			this.idx = i;
			this.priority = p;
		}
	}

	public int solution(int[] priorities, int location) {
		int answer = 0;

		for (int i = 0; i < priorities.length; i++) {
			Process p = new Process(i, priorities[i]);
			q.add(p);
			pq.add(p);
		}
		int count = 1;
		while (!q.isEmpty() && !pq.isEmpty()) {
			while (q.peek().idx != pq.peek().idx) {
				if (q.peek().priority == pq.peek().priority) break;
				q.add(q.poll());
			}
			pq.poll();
			if (q.poll().idx == location) {
				return count;
			}
			count++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new 프로세스().solution(new int[]{1, 1, 9, 1, 1, 8, 1, 1}, 0));
	}
}
// [5, 4, 3, 2, 1], 4