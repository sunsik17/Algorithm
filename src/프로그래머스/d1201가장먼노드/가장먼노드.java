import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] visited;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        this.visited = new int[n + 1];

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Arrays.fill(visited, Integer.MAX_VALUE - 1);
        int max = bfs();
        Arrays.sort(visited);
        for (int i = n; i >= 0; i--) {
            if (visited[i] == Integer.MAX_VALUE - 1) continue;
            if (max == visited[i]) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }

    private int bfs() {
        int res = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> adjs = graph.get(cur);
            for (int adj : adjs) {
                if (visited[adj] == Integer.MAX_VALUE - 1) {
                    visited[adj] = visited[cur] + 1;
                    res = Math.max(res, visited[cur] + 1);
                    q.add(adj);
                }
            }
        }
        return res;
    }
}
