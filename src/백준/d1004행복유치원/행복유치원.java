import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class 행복유치원 {
    static int N, K;
    static int[] kids;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kids = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            tmp[i] = Math.abs(kids[i] - kids[i + 1]);
        }

        Arrays.sort(tmp);
        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += tmp[i];
        }
        System.out.println(answer);
    }
}
