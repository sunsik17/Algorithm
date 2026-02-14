import java.util.HashSet;
import java.util.Set;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    String[] tmp;

    public int solution(String numbers) {
        tmp = numbers.split("");
        visited = new boolean[tmp.length];

        for (int i = 1; i <= tmp.length; i++) {
            dfs("", i);
        }

        int answer = 0;

        for (int num : set) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    private void dfs(String current, int length) {
        if (current.length() == length) {
            set.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < tmp.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + tmp[i], length);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}