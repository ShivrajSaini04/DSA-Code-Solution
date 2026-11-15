class Solution {
    public long maxDifference(int[] nums) {
        int n = nums.length;
        if (n== 1) return nums[0];
        
        long[] dp = new long[n+1];
        
         for(int i =n-1;i>=0;i--){
             
             long sum = nums[i];
             
             if (sum % 3 ==0) dp[i] = sum - dp[i+1];
             else dp[i] = sum + dp[i+1];

             if (i + 1 < n) {
                 sum += nums[i+1];
                 long curr ;

                 if (sum % 3 ==0) curr = sum - dp[i+2];
                 else curr = sum + dp[i+2];

                 dp[i] = Math.max(dp[i],curr);
             }
         }
        

        return dp[0];
    }
}