import java.util.*;

class Solution {
    boolean[][] visited;
    Queue<int[]> q = new LinkedList<>();
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if ('X' != maps[i].charAt(j) && !visited[i][j]) {
                    ans.add(bfs(i, j, maps));
                }
            }
        }

        if (ans.isEmpty()) {
            return new int[]{-1};
        }
        ans.sort((x, y) -> x - y);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(int i, int j, String[] maps) {
        visited[i][j] = true;
        int result = 0;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            result += (maps[cur[0]].charAt(cur[1]) - 48);
            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dx[k];
                int nY = cur[1] + dy[k];

                if (nX >= 0 && nY >= 0 &&
                        nX < maps.length &&
                        nY < maps[0].length() &&
                        !visited[nX][nY] &&
                        maps[nX].charAt(nY) != 'X') {
                    q.add(new int[]{nX, nY});
                    visited[nX][nY] = true;
                }
            }
        }
        return result;
    }
}