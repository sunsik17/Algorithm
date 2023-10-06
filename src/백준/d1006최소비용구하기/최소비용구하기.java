import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class 최소비용구하기 {
    static int n, m, start, end;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(v).add(new int[]{to, weight});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();

        System.out.println(dist[end]);
    }

    static void dijkstra() {
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dist[cur[0]] < cur[1]) continue;
            if (cur[0] == end) return;

            List<int[]> adjNodes = graph.get(cur[0]);

            for(int[] node : adjNodes) {
                if (dist[node[0]] > node[1] + cur[1]) {
                    dist[node[0]] = node[1] + cur[1];
                    pq.add(new int[]{node[0], dist[node[0]]});
                }
            }
        }
    }
}
