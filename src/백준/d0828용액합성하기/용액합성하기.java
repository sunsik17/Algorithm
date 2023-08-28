import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 용액합성하기{

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int answer = Integer.MAX_VALUE;
        int tmp = 0;
        while (left < right) {
            int result = A[left] + A[right];
            if (result > 0) {
                right--;
            } else if (result < 0) {
                left++;
            } else {
                System.out.println(result);
                return;
            }
            if (Math.abs(result) < Math.abs(answer)) {
                answer = result;
            }
            answer = Math.min(Math.abs(result), answer);
        }
        System.out.println(answer);
    }
}
