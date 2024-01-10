package 프로그래머스.d230110삼각달팽이;

import java.util.*;

class 삼각달팽이 {
	int[] dx = {1, 0, -1, 1};
	int[] dy = {0, 1, -1, 0};
	int[][] visited;
	int num = 1;
	int finalNum = 0;
	public int[] solution(int n) {
		int[] answer = {};
		visited = new int[n][n];
		move(n);
		finalNum = num;
		int idx = 0;
		answer = new int[finalNum - 1];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if (visited[i][j] != 0) {
					answer[idx++] = visited[i][j];
				}
			}
		}
		return answer;
	}
	private void move(int n) {
		visited[0][0] = num++;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0});
		int idx = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int nX = cur[0] + dx[idx];
			int nY = cur[1] + dy[idx];

			if(nX >= 0 && nY >= 0 && nX < n && nY < n) {
				if (visited[nX][nY] == 0){
					visited[nX][nY] = num++;
					q.add(new int[]{nX, nY});
				} else {
					idx++;
					if(idx > 3) {
						idx %= 3;
					}
					nX = cur[0] + dx[idx];
					nY = cur[1] + dy[idx];
					if(nX >= 0 && nY >= 0 && nX < n && nY < n && visited[nX][nY] == 0) {
						q.add(cur);
					}
				}
			} else {
				idx++;
				if(idx > 3) {
					idx %= 3;
				}
				nX = cur[0] + dx[idx];
				nY = cur[1] + dy[idx];
				if(nX >= 0 && nY >= 0 && nX < n && nY < n && visited[nX][nY] == 0) {
					q.add(cur);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 삼각달팽이().solution(4)));
	}
}
