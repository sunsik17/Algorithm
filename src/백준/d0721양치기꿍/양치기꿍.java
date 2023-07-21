package 백준.d0721양치기꿍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기꿍 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int R, C;
	static int[] arr = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(String.valueOf(arr[0]) + ' ' + arr[1]);
	}
	static void bfs(int x, int y) {
		int v = 0;
		int k = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		if (map[x][y] != '.') {
			if (map[x][y] == 'v') {
				v++;
			} else {
				k++;
			}
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = dx[i] + cur[0];
				int nY = dy[i] + cur[1];

				if (nX >= 0 && nY >= 0 && nX < R && nY < C && !visited[nX][nY] && map[nX][nY] != '#') {
					q.add(new int[]{nX, nY});
					visited[nX][nY] = true;

					if (map[nX][nY] != '.') {
						if (map[nX][nY] == 'v') {
							v++;
						} else {
							k++;
						}
					}
				}
			}
		}
		if (v < k) {
			arr[0] += k;
		} else {
			arr[1] += v;
		}
	}
}
