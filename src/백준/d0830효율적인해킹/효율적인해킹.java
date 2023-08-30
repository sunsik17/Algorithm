import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int N;
    static int M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static List<int[]> result = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(y).add(x);
        }
        visited = new boolean[N + 1];
        visited[0] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) bfs(i);
        }

        result.sort((x,y) -> y[1] - x[1] == 0 ? x[0] - y[0] : y[1] - x[1]);
        StringBuilder sb = new StringBuilder();
        for (int[] arr : result) {
            if (arr[1] == max) sb.append(arr[0]).append(' ');
            else break;
        }

        System.out.println(sb);
    }

    private static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> adj = graph.get(cur);

            for (int i = 0; i < adj.size(); i++) {
                int next = adj.get(i);

                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        result.add(new int[]{idx, count});
        max = Math.max(max, count);
    }
}
