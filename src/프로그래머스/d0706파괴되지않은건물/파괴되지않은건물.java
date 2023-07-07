package 프로그래머스.d0706파괴되지않은건물;

import java.util.LinkedList;
import java.util.Queue;

public class 파괴되지않은건물 {
	boolean[][] visited;
	int[][] sum;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, -1, 0, 1};
	int count = 0;
	int n, m;
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		n = board.length;
		m = board[0].length;
		sum = new int[n + 1][m + 1];
		for (int[] s : skill) {
			int x1 = s[1], x2 = s[3];
			int y1 = s[2], y2 = s[4];
			int degree = (s[0] == 1 ? -1 : 1) * s[5];

			sum[x1][y1] += degree;
			sum[x1][y2 + 1] += -degree;
			sum[x2 + 1][y1] += -degree;
			sum[x2 + 1][y2 + 1] += degree;
		}
		operate();
		visited = new boolean[n][m];
		dfs(board, 0, 0);
		return count;
	}
	private void operate() {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum[i][j] += sum[i - 1][j];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum[j][i] += sum[j][i - 1];
			}
		}
	}
	private void dfs(int[][] board, int x, int y) {
		visited[x][y] = true;
		if (board[x][y] + sum[x][y] > 0) {
			count++;
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			if (nX >= 0 && nY >= 0 && nX < n && nY < m && !visited[nX][nY]) {
				dfs(board, nX, nY);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new 파괴되지않은건물().solution(
			new int[][]{
				{5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5}
			},
			new int[][]{
				{1, 0, 0, 3, 4, 4},
				{1, 2, 0, 2, 3, 2},
				{2, 1, 0, 3, 1, 2},
				{1, 0, 1, 3, 3, 1}
			}));
	}
}
