class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            int rem = num % k;

            // Start a new subarray
            next[rem] = 1;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                int newRem = (int) ((1L * r * rem) % k);
                next[newRem] += dp[r];
            }

            // Add current subarrays to answer
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}