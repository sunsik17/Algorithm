import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static boolean[][] map = new boolean[1080][1920];
    static int[][] visited = new int[1080][1920];
    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, -1, 0, 1};
    static int beforeMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String str;
        StringTokenizer st;
        while ((str = br.readLine()) != null && !str.equals(" ")) {
            st = new StringTokenizer(str);
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            mapChange(x1, y1, x2, y2);
        }

        for (int i = 0; i < 1080; i++) {
            for (int j = 0; j < 1920; j++) {
                if (visited[i][j] == 0 && map[i][j]) {
                    bfs(i, j);
                }
            }
        }
        final int answer = beforeMax - 1;
        System.out.println(answer);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = beforeMax++;
        map[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dx[k];
                int nY = cur[1] + dy[k];

                if (nX >= 0 && nY >= 0 && nX < 1080 && nY < 1920 && visited[nX][nY] == 0 && map[nX][nY]) {
                    q.add(new int[]{nX, nY});
                    visited[nX][nY] = beforeMax++;
                }
            }
        }
    }

    private static void mapChange(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                if (!map[i][j]) map[i][j] = true;
            }
        }
    }
}
