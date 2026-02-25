import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int[] answer = new int[N];
        int idx = 0;
        while(N-- > 0) {
            int i = commands[idx][0] - 1;
            int j = commands[idx][1] - 1;
            int k = commands[idx][2];
            
            int len = j - i + 1;
            int[] tmp = new int[len];
            
            int idx2 = 0;
            for (int l = i; l <= j; l++) {
                tmp[idx2++] = array[l];
            }
            
            Arrays.sort(tmp);
            
            answer[idx++] = tmp[k - 1];
        }
        return answer;
    }
}