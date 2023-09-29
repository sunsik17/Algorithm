import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class DangerousDive {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] person = new int[N + 1];
        for (int i = 0; i <= N; i++){
            person[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++){
            person[Integer.parseInt(st.nextToken())] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){
            if(person[i] != 0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().equals("") ? "*" : sb);
    }
}
