import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 애너그램 {
    static int N;
    static int[] alpha;
    static char[][] strings;
    static Stack<Character> stack = new Stack<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strings = new char[N][];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine().toCharArray();
        }

        for (char[] tmp : strings) {
            alpha = new int[26];
            int len = tmp.length;
            for (char c : tmp) {
                alpha[c - 'a']++;
            }
            dfs(tmp, len);
            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void dfs(char[] chars, int len) {
        if (stack.size() == len) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : stack) {
                stringBuilder.append(c);
            }
            pq.add(stringBuilder.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                stack.push((char) (i + 'a'));
                dfs(chars, len);
                stack.pop();
                alpha[i]++;
            }
        }
    }
}

