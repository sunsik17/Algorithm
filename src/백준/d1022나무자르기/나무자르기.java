import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class 나무자르기 {
    static int n;
    static int[] h, a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        h = new int[n];
        a = new int[n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    h[j] = Integer.parseInt(st.nextToken());
                }else {
                    a[j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] == x[1] ? y[0] - x[0] : y[1] - x[1]);

        for (int i = 0; i < h.length; i++) {
            pq.add(new int[]{h[i], a[i]});
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            answer += ((long)(cur[1] * --n) + cur[0]);
        }

        System.out.println(answer);
    }
}
