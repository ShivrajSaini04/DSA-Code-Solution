class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return solve(0,n-1,piles) > 0;
    }

    int solve(int left , int rig ,int[] piles){
        if (left == rig) return piles[left];
        if (dp[left][rig] != null) return dp[left][rig];

        int leftStone = piles[left] - solve(left +1 ,rig,piles);
        int rightStone = piles[rig] - solve(left ,rig - 1 ,piles);

        return dp[left][rig] = Math.max(leftStone,rightStone);
    }
}