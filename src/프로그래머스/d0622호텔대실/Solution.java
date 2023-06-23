package 프로그래머스.d0622호텔대실;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
	List<int[]> list = new ArrayList<>();
	public int solution(String[][] book_time) {
		int answer = 0;
		add(book_time);
		list.sort((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);

		for(int i = 0; i < list.size(); i++) {
			while(!pq.isEmpty() && pq.peek()[1] <= list.get(i)[0]) {
				pq.poll();
			}
			pq.add(list.get(i));

			answer = Math.max(pq.size(), answer);
		}
		return answer;
	}

	private void add(String[][] book_time) {
		for (String[] strs : book_time) {
			int start = Integer.parseInt(strs[0].replace(":", ""));
			int end = Integer.parseInt(strs[1].replace(":", "")) + 10;
			String e = String.valueOf(end);
			if (e.charAt(e.length() - 2) == '6') {
				end += 40;
			}
			list.add(new int[]{start, end});
		}
	}

	public static void main(String[] args) {

		String[][] book_time = {
			{"15:00", "17:00"},
			{"16:40", "18:20"},
			{"14:20", "15:20"},
			{"14:10", "19:20"},
			{"18:20", "21:20"},
		};

		System.out.println(new Solution().solution(book_time));
	}
}
