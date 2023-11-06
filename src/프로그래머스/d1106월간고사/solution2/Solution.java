package 프로그래머스.d1106월간고사.solution2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	final int[] dx = {-1, 0, 1, 0};
	final int[] dy = {0, -1, 0, 1};
	int[][] visited;
	Queue<int[]> q;

	public int[] solution(int N, String[][] board) {
		q = new LinkedList<>();
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].equals("G")) {
					q.add(new int[]{i, j});
					visited[i][j] = 1;
				}
			}
		}

		return bfs(N, board);
	}

	private int[] bfs(int N, String[][] board) {
		int max = -1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nX = dx[i] + cur[0];
				int nY = dy[i] + cur[1];

				if (nX >= 0 && nY >= 0 && nX < N && nY < N && visited[nX][nY] == 0) {
					if (board[nX][nY].equals("B")) {
						q.add(new int[]{nX, nY});
						visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
						max = Math.max(visited[nX][nY], max);
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == max) {
					return new int[]{i, j};
				}
			}
		}
		return new int[0];
	}
	public static void main(String[] args) {
		int N = 5;
		String[][] board = {{"B", "B", "B", "B", "B"}, {"B", "G", "B", "B", "B"}, {"B", "B", "B", "G", "B"}, {"B", "B", "B", "B", "B"}, {"B", "B", "G", "B", "B"}};
		System.out.println(Arrays.toString(new Solution().solution(N, board)));
	}
}
