import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class 보물섬 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] visited;
    static char[][] map;
    static Queue<int[]> q;
    static int answer = Integer.MIN_VALUE;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[x][y] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if (nX >= 0 && nY >= 0 && nX < n && nY < m && visited[nX][nY] == -1 && map[nX][nY] == 'L') {
                    q.add(new int[]{nX, nY});
                    visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
                    answer = Math.max(answer, visited[nX][nY]);
                }
            }
        }
    }
}
