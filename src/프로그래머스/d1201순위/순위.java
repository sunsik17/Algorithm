import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class 순위 {
    List<List<Integer>> v = new ArrayList<>();
    List<List<Integer>> l = new ArrayList<>();
    boolean[] vVisited;
    boolean[] lVisited;
    public int solution(int n, int[][] results) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            v.add(new ArrayList<>());
            l.add(new ArrayList<>());
        }

        for (int[] res : results) {
            v.get(res[0]).add(res[1]);
            l.get(res[1]).add(res[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            if(bfs(i, n)) answer++;
        }
        return answer;
    }
    private boolean bfs(int start, int n) {
        this.vVisited = new boolean[n + 1];
        this.lVisited = new boolean[n + 1];
        Queue<Integer> vq = new LinkedList<>();
        Queue<Integer> lq = new LinkedList<>();
        vq.add(start);
        lq.add(start);

        vVisited[start] = true;
        lVisited[start] = true;
        while(!vq.isEmpty()) {
            int vcur = vq.poll();

            List<Integer> vAdjs = v.get(vcur);
            for (int adj : vAdjs) {
                if (!vVisited[adj]) {
                    vVisited[adj] = true;
                    vq.add(adj);
                }
            }
        }
        while(!lq.isEmpty()) {
            int lcur = lq.poll();
            List<Integer> lAdjs = l.get(lcur);
            for (int adj : lAdjs) {
                if (!lVisited[adj]) {
                    lVisited[adj] = true;
                    lq.add(adj);
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            if (lVisited[i] || vVisited[i]) {
                res++;
            }
        }
        return res == n;
    }
    
}
