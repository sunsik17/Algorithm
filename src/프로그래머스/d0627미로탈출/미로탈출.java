package 프로그래머스.d0627미로탈출;

import java.util.Queue;
import java.util.LinkedList;

public class 미로탈출 {
    char[][] map;
    int[][] visited;
    int[][] visited2;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int n, m;
    int sum = 0;
    int[] xy = new int[2];

    public int solution(String[] maps) {
        int answer = 0;
        n = maps[0].length();
        m = maps.length;

        map = new char[m][n];

        int idx = 0;
        for (String str : maps) {
            map[idx++] = str.toCharArray();
        }
        boolean isFind = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S') {
                    visited = new int[m][n];
                    isFind = findL(i, j);
                    if (!isFind) {
                        return -1;
                    }
                } else if (isFind) {
                    visited2 = new int[m][n];
                    answer = bfs(xy[0], xy[1]);
                    if (answer < 0) {
                        return -1;
                    }
                }
            }
        }
        answer += sum;
        return answer;
    }

    private boolean findL(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if (nX >= 0 && nY >= 0 && nX < m && nY < n
                    && visited[nX][nY] == 0 && map[nX][nY] != 'X') {
                    visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
                    if (map[nX][nY] == 'L') {
                        xy[0] = nX;
                        xy[1] = nY;
                        sum += visited[nX][nY];
                        return true;
                    }
                    q.add(new int[]{nX, nY});
                }
            }
        }
        return false;
    }

    private int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited2[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if (nX >= 0 && nY >= 0 && nX < m && nY < n
                    && visited2[nX][nY] == 0 && map[nX][nY] != 'X') {
                    visited2[nX][nY] = visited2[cur[0]][cur[1]] + 1;
                    if (map[nX][nY] == 'E') {
                        return visited2[nX][nY];
                    }
                    q.add(new int[]{nX, nY});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new 미로탈출().solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}