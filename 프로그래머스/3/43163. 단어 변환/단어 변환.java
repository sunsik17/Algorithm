import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    Map<String, Integer> visited = new HashMap<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.toString(words).contains(target)) return 0;

        Map<String, List<String>> map = new HashMap<>();
        map.put(begin, new ArrayList<>());
        for(String word : words){
            map.put(word, new ArrayList<>());
        }

        for (String key : map.keySet()) {
            visited.put(key, -1);
            for (String word : words) {
                if (key.equals(word)) continue;
                if (check(key.toCharArray(), word.toCharArray())) {
                    map.getOrDefault(key, new ArrayList<>()).add(word);
                }
            }
        }
        bfs(map, begin, target);
        return visited.get(target);
    }

    private void bfs(Map<String, List<String>> map, String begin, String target) {
        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        visited.put(begin, count);
        while (!q.isEmpty()) {
            String cur = q.poll();
            List<String> adj = map.get(cur);
            for (String s : adj) {
                if (visited.get(s) == -1) {
                    visited.put(s, visited.get(cur) + 1);
                    q.add(s);
                }
            }
        }
    }

    private boolean check(char[] kC, char[] wC) {
        int count = 0;
        for (int i = 0; i < kC.length; i++) {
            if (kC[i] != wC[i]) count++;
            if (count > 1) return false;
        }
        return true;
    }
}