class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return (int)dp[n];
    }
}