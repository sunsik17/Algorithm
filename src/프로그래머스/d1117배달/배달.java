import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class 배달 {
    List<List<int[]>> graph = new ArrayList<>();
    int[] dist;
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int val = road[i][2];
            graph.get(x).add(new int[]{y, val});
            graph.get(y).add(new int[]{x, val});
        }
        
        dijkstra();
        
        for (int i : dist) {
            if(i <= K) answer++;
        }
        return answer;
    }
    
    private void dijkstra() {
        dist[1] = 0;
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(cur[1] > dist[cur[0]]) continue;
            
            for (int[] adjNode : graph.get(cur[0])) {
                if(dist[adjNode[0]] > cur[1] + adjNode[1]) {
                    dist[adjNode[0]] = cur[1] + adjNode[1];
                    pq.add(new int[]{adjNode[0], dist[adjNode[0]]});
                }
            }
        }
    }
}
