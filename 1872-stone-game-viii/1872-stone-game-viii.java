class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Prefix Sum
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Start with total sum
        int dp = stones[n - 1];

        // Right to left
        for (int i = n - 2; i > 0; i--) {
            dp = Math.max(dp, stones[i] - dp);
        }

        return dp;
    }
}