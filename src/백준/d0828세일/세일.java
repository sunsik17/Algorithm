import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class 세일{

    static int N;
    static Integer[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        C = new Integer[N];

        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(C, Collections.reverseOrder());
        long result = 0;
        int cnt = 0;
        for (int i : C) {
            if (cnt == 2) {
                cnt = 0;
                continue;
            }
            result += i;
            cnt++;
        }

        System.out.println(result);
    }
}
