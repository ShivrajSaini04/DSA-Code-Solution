class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1_000_000_007;

        int[] dp = new int[26];

        for (char ch : s.toCharArray()) {

            int sum = 0;

            for (int i = 0; i < 26; i++) {
                sum = (sum + dp[i]) % MOD;
            }

            dp[ch - 'a'] = (sum + 1) % MOD;
        }

        int ans = 0;

        for (int x : dp) {
            ans = (ans + x) % MOD;
        }

        return ans;
    }
}