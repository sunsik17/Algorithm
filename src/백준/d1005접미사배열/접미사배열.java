import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class 접미사배열 {
    static String str;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        int len = str.length();
        arr = new String[len];

        for (int i = 0; i < len; i++) {
            arr[i] = str.substring(i);
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(
                s -> sb.append(s).append('\n')
        );

        System.out.println(sb);
    }
}
