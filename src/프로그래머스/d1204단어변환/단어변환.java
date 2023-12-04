package programmers;

import java.util.*;

class Solution {
    // 단어변환
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
                if (isValid(key.toCharArray(), word.toCharArray())) {
                    map.getOrDefault(key, new ArrayList<>()).add(word);
                }
            }
        }

        System.out.println(map);
        bfs(map, begin);
        return visited.get(target);
    }

    private void bfs(Map<String, List<String>> map, String begin) {
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        visited.put(begin, 0);
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

    private boolean isValid(char[] kC, char[] wC) {
        int count = 0;
        for (int i = 0; i < kC.length; i++) {
            if (kC[i] != wC[i]) count++;
            if (count > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
