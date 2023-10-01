import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class 피카츄 {
    static String S;
    static Queue<Character> q = new LinkedList<>();
    static Stack<String> pikachu = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        pikachu.add("pi");
        pikachu.add("ka");
        pikachu.add("chu");

        for (char c : S.toCharArray()) {
            q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        String s = "";
        while (!q.isEmpty()) {
            sb.append(q.poll());
            s = sb.toString();
            int len = sb.toString().length();
            if (len == 2) {
                if (pikachu.contains(s)) {
                    sb = new StringBuilder();
                }
            } else if (len == 3) {
                if (pikachu.contains(s)) {
                    sb = new StringBuilder();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (!sb.toString().equals("")) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
