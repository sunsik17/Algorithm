package 프로그래머스.d0626과제진행하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class 과제진행하기 {

	static class Plan {

		String name;
		int start;
		int playtime;

		public Plan(String name, int start, int playtime) {
			this.name = name;
			this.start = start;
			this.playtime = playtime;
		}
	}

	Stack<Plan> stack = new Stack<>();
	PriorityQueue<Plan> pq = new PriorityQueue<>((x, y) -> x.start - y.start);
	List<String> names = new ArrayList<>();

	public String[] solution(String[][] plans) {
		for (String[] plan : plans) {
			String name = plan[0];
			int start = getMinute(plan[1].split(":"));
			int playtime = Integer.parseInt(plan[2]);
			pq.add(new Plan(name, start, playtime));
		}

		while (!pq.isEmpty()) {
			Plan cur = pq.poll();
			if (stack.size() == 0) {
				stack.add(cur);
			} else {
				Plan tmp = stack.pop();
				int endTime = tmp.start + tmp.playtime; // 진행중인과제종료시간

				if (endTime > cur.start) { //진행중인 과제가 종료되기전에 새로운 과제가 시작될때
					tmp.playtime -= cur.start - tmp.start; //진행중이던 과제의 남은 플레이타임 업데이트

					if (tmp.playtime < 0) { // 진행중인과제 플레이타임이 음수 일때 다른 남은과제 시작
						int i = tmp.playtime;
						names.add(tmp.name);
						while (!stack.isEmpty()) {
							Plan tmp2 = stack.pop();
							i += tmp2.playtime;
							if (i == 0) {
								names.add(tmp2.name);
								break;
							} else if (i > 0) {
								tmp2.playtime = i;
								stack.add(tmp2);
								break;
							} else {
								names.add(tmp2.name);
							}
						}
						stack.add(cur);
					} else if (tmp.playtime == 0) {
						names.add(tmp.name);
						stack.add(cur);
					} else {
						stack.add(tmp);
						stack.add(cur);
					}
				} else if (endTime == cur.start) {
					names.add(tmp.name);
					stack.add(cur);
				} else {
					names.add(tmp.name);
					int i = endTime - cur.start;
					while (!stack.isEmpty()) {
						Plan tmp2 = stack.pop();
						i += tmp2.playtime;
						if (i == 0) {
							names.add(tmp2.name);
							break;
						} else if (i > 0) {
							tmp2.playtime = i;
							stack.add(tmp2);
							break;
						} else {
							names.add(tmp2.name);
						}
					}
					stack.add(cur);
				}
			}
		}
		while (!stack.isEmpty()) {
			names.add(stack.pop().name);
		}
		return names.toArray(new String[0]);
	}
	private int getMinute(String[] time) {
		return (Integer.parseInt(time[0]) * 60) + (Integer.parseInt(time[1]));
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 과제진행하기().solution(
			new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));
	}
}
