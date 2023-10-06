import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class 박터뜨리기 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int finalSum = 0;
        for (int i = 1; i <= k; i++) {
            finalSum += i;
        }

        if (n < finalSum) {
            System.out.println(-1);
            return;
        }
        n -= finalSum;

        if (n % k == 0) System.out.println(k - 1);
        else System.out.println(k);

    }
}
