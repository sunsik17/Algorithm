package 프로그래머스.d0703네트워크;

import java.util.*;

class 네트워크 {
	List<List<Integer>> graph = new ArrayList<>();
	int[] visited;
	int len;

	public int solution(int n, int[][] computers) {
		int answer = 1;
		len = computers.length;
		visited = new int[n];

		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (i != j && computers[i][j] == 1) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}

		Queue<Integer> q = new LinkedList<>(graph.get(0));
		Arrays.fill(visited, -1);
		while (true) {
			while (!q.isEmpty()) {
				int cur = q.poll();
				if (visited[cur] != 1) {
					visited[cur] = 1;
				}

				for (int i = 0; i < graph.get(cur).size(); i++) {
					if (visited[graph.get(cur).get(i)] == -1) {
						visited[graph.get(cur).get(i)] = 1;
						q.add(graph.get(cur).get(i));
					}
				}
			}
			boolean isPass = true;
			for (int i = 0; i < n; i++) {
				if (visited[i] == -1) {
					visited[i] = 1;
					q = new LinkedList<>(graph.get(i));
					isPass = false;
					answer++;
					break;
				}
			}
			if (isPass) {
				break;
			}
		}
		System.out.println(Arrays.toString(visited));
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(new 네트워크().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}
}
