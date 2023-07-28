class Solution {
    public long solution(int n) {
        if(n == 1) return 1L;
        if(n == 2) return 2L;
        long[] dp = new long[n];
        dp[0] = 1L;
        dp[1] = 2L;
        for(int i=2;i<n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }
        return dp[n-1];
    }
}