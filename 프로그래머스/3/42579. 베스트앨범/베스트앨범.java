import java.util.*;

class Solution {
    static class Song{
        int finalNum;
        String genre;
        int count;

        public Song(int finalNum, String genre, int count) {
            this.finalNum = finalNum;
            this.genre = genre;
            this.count = count;
        }
        public Song(String genre, int count) {
            this.genre = genre;
            this.count = count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<Song> songList = new ArrayList<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], 0);
            songList.add(new Song(i, genres[i], plays[i]));
        }

        for (Song song : songList) {
            map.put(song.genre, map.getOrDefault(song.genre, 0) + song.count);
        }

        PriorityQueue<Song> pq = new PriorityQueue<>((x, y) -> y.count - x.count);

        for(String key : map.keySet()) {
            pq.add(new Song(key, map.get(key)));
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        songList.sort((x, y) -> y.count == x.count ? x.finalNum - y.finalNum : y.count - x.count);
        while(!pq.isEmpty()) {
            String genre = pq.poll().genre;
            int cnt = 0;
            for (Song s : songList) {
                if (s.genre.equals(genre)) {
                    res.add(s.finalNum);
                    cnt++;
                    if (cnt == 2) {
                        break;
                    }
                }
            }
        }

        return res.stream().mapToInt(x -> x).toArray();
    }
}