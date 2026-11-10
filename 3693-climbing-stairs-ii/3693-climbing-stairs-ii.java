
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = Math.max(0, i - 3); j < i; j++) {

                int jump = i - j;

                int cost = dp[j] + costs[i - 1] + jump * jump;

                min = Math.min(min, cost);
            }

            dp[i] = min;
        }

        return dp[n];
    }
}
