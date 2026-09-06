class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int ans = 0;
        int half = n/2;
        for (int ele : nums) sum += ele;

        long prefixSum = 0;
        for (int i=0;i<half;i++){
            prefixSum += nums[i];
        }

        for (int i=0;i<n;i++){

            if (2 * prefixSum > sum) ans++;
            prefixSum += nums[(i+ half) % n];

            prefixSum -= nums[i];
        }
        return ans;
    }
}