package 백준.d0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달리기 {

	static int N, M, K, x1, y1, x2, y2;
	static int[][] visited;
	static char[][] map;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());

		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		visited[x1 - 1][y1 - 1] = 0;
		q.add(new int[]{x1 - 1, y1 - 1});
		bfs();

		int answer = visited[x2 - 1][y2 - 1];
		System.out.println(Arrays.deepToString(visited));
		System.out.println(answer == 0 ? -1 : answer);
	}
	private static void bfs() {

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= K; j++) {
					int nX = cur[0] + (dx[i] * j);
					int nY = cur[1] + (dy[i] * j);

					if (nX >= 0 && nY >= 0 && nX < N && nY < M && map[nX][nY] == '.') {
						if (nX == x1 - 1 && nY == y1 - 1) continue;
						if (visited[nX][nY] == 0) {
							visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
							if (nX == x2 - 1 && nY == y2 - 1) {
								return;
							}
							q.add(new int[]{nX, nY});
						} else if (visited[nX][nY] <= visited[cur[0]][cur[1]]){
							break;
						}
					} else {
						break;
					}
				}
			}
		}
	}
}