class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        for (int i=0;i<n;i++){
            sum += nums[i];

            while (sum >= target) {
                ans = Math.min(ans, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}