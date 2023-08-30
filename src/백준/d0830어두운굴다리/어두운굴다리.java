import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class 어두운굴다리{

    static int N;
    static int M;
    static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < M + 1; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        x[M + 1] = N;
        x[0] = 0;
        Arrays.sort(x);
        int tmp = Math.max(x[1] - x[0], x[M + 1] - x[M]);
        int result = -1;
        for (int i = 1; i < x.length - 2; i++) {
            result = Math.max((x[i + 1] - x[i]) % 2 == 0 ? (x[i + 1] - x[i]) / 2 : ((x[i + 1] - x[i]) / 2) + 1, result);
        }
        result = Math.max(result, tmp);
        System.out.println(result);
    }
}
