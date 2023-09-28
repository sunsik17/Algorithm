import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 기상청인턴신현수 {
    static int N, K;
    static int[] doC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        doC = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            doC[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        int tmp = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (i < K) {
                tmp+=doC[i];
                if (i == K - 1) answer = Math.max(answer, tmp);
                continue;
            } else {
                tmp+=doC[i];
                tmp-=doC[idx++];
            }
            answer = Math.max(tmp, answer);
        }
        System.out.println(answer);
    }
}
