class Solution {
    int res = 0;
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        //int[] dp = new int[n + 1];
        //dp[1] = 1;
        //dp[2] = 2;
        int prev2 = 1;
        int prev = 2;
        for(int i = 3; i <= n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
            //dp[i] = dp[i - 1] + dp[i -2];
        }
        return prev;
    }
}