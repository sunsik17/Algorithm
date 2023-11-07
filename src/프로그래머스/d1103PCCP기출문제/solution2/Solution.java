package 프로그래머스.d1103PCCP기출문제.solution2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

	int[][] visited;
	final int[] dx = {-1, 0, 1, 0};
	final int[] dy = {0, -1, 0, 1};
	Queue<int[]> q;
	int xLen, yLen;
	int count = 1;
	List<Integer> list = new ArrayList<>();
	public int solution(int[][] land) {
		int answer = 0;
		this.xLen = land.length;
		this.yLen = land[0].length;
		this.visited = new int[xLen][yLen];
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				if (land[i][j] == 1 && visited[i][j] == 0) {
					bfs(i, j, land);
				}
			}
		}
		for (int i = 0; i < yLen; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < xLen; j++) {
				if (visited[j][i] != 0) {
					set.add(visited[j][i]);
				}
			}
			int res = 0;
			for (int a : set) {
				res += list.get(a - 1);
			}
			answer = Math.max(answer, res);
		}

		return answer;
	}
	private void bfs(int x, int y, int[][] land) {
		visited[x][y] = count;
		int result = 1;
		q = new LinkedList<>();
		q.add(new int[]{x, y});

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = dx[i] + cur[0];
				int nY = dy[i] + cur[1];

				if (nX >= 0 && nY >= 0 && nX < xLen && nY < yLen &&
					visited[nX][nY] == 0 && land[nX][nY] == 1) {
					q.add(new int[]{nX, nY});
					result++;
					visited[nX][nY] = count;
				}
			}
		}
		count++;
		list.add(result);
//		dfs(x, y, result);
	}
	private void dfs(int x, int y, int value) {
		if (visited[x][y] >= value) return;
		visited[x][y] = value;
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			if (nX >= 0 && nY >= 0 && nX < xLen && nY < yLen &&
			visited[nX][nY] > 0) {
				dfs(nX, nY, value);
			}
		}
	}

	public static void main(String[] args) {
		int[][] land =
			{
				{0, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 1, 1, 0, 0},
				{1, 1, 0, 0, 0, 1, 1, 0},
				{1, 1, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0, 1, 1}
			};

		System.out.println(new Solution().solution(land));
	}
}
