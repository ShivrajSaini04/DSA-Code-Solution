class Solution {
    public int[] runningSum(int[] nums) {
        int preSum = 0;

        for(int i=0;i<nums.length;i++){
           preSum += nums[i];
           nums[i] = preSum;
        }
        return nums;
    }
}