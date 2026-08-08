class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long currSum = 0;
        long maxSum = 0;

        for (int i = 0; i < n; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];

            if (i >= k) {
                currSum -= nums[i - k];
                map.put(nums[i - k], map.get(nums[i - k]) - 1);

                if (map.get(nums[i - k]) == 0) {
                    map.remove(nums[i - k]);
                }
            }

            if (i>=k-1 && map.size()==k){
               maxSum = Math.max(maxSum, currSum);
            }  
        }
        return maxSum;
    }
}