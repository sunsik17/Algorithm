public class Solution {
    public int dfs (int k, int[][] dunjeons){
        int cnt = 0;
        for(int[] tmp : dunjeons){
            int a = tmp[0];
            int b = tmp[1];
            if (a <= k) {
                tmp[0] = 5001;
                cnt = Math.max(dfs(k - b, dunjeons) + 1, cnt);
                tmp[0] = a;
            }
        }
        return cnt;
    }
    public int solution (int k, int[][] dunjeons){
        
        return dfs (k, dunjeons);
    }

}