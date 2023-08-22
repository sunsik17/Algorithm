package 백준.d0822점프왕쩰리Large;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class 점프왕쩰리Large{
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.add(new int[]{0, 0, map[0][0]});

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[2] <= 0) break;

			for (int i = 0; i < 2; i++) {
				int count = cur[2];
				int nX = cur[0] + (dx[i] * count);
				int nY = cur[1] + (dy[i] * count);
				if (nX >= 0 && nY >= 0 && nX < N && nY < N && !visited[nX][nY]) {
					if (nX == N - 1 && nY == N - 1) {
						System.out.println("HaruHaru");
						return;
					}
					q.add(new int[]{nX, nY, map[nX][nY]});
					visited[nX][nY] = true;
				}
			}
		}

		System.out.println("Hing");
	}
}

