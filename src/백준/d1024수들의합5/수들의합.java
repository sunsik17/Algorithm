import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class 수들의합 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int answer = 0;
        int[] num = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            num[i] = i;
        }

        int left = 1;
        int right = 1;
        int result = num[left];
        while (left <= right) {
            if (result == n) {
                answer++;
                result -= num[left++];
            } else if (result < n && right < n) {
                result += num[++right];
            } else {
                result -= num[left++];
            }
        }
        System.out.println(answer);
    }

}
