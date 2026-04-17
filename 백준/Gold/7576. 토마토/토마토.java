import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Main {
	static int[][] tomato;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int M, N;
	static Queue<int[]> q = new LinkedList<>();
	static int max;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) {
					q.add(new int[]{i, j});
					visited[i][j] = 1;
				}
			}
		}
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0 && tomato[i][j] != -1) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max > 0 ? max - 1 : max);
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dx[i];
				int nY = cur[1] + dy[i];

				if (nX < 0 || nY < 0 || nX >= N || nY >= M || tomato[nX][nY] == -1 || visited[nX][nY] != 0) {
					continue;
				}
				q.add(new int[]{nX, nY});
				visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
				max = Math.max(max, visited[nX][nY]);
			}
		}
	}
}