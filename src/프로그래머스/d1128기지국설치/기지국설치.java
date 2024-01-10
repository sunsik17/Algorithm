class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1;
        int len = (w * 2) + 1;
        for (int i = 0; i < stations.length; i++) {
            int tmp = stations[i] - w;
            if (idx < tmp) {
                if ((tmp - idx) % len == 0) {
                    answer += (tmp - idx) / len;
                } else {
                    answer += ((tmp - idx) / len) + 1;
                }
            }
            idx = stations[i] + w + 1;
        }

        if (idx <= n) {
            int dif = n - idx + 1;
            if (dif % len == 0) {
                answer += dif / len;
            } else {
                answer += dif / len + 1;
            }
        }
        return answer;
    }
}
