class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;
        int sum = nums[0];

        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (i != 1)
                sum -= nums[i - 2];
            if (set.contains(sum))
                return true;
            set.add(sum);

        }
        return false;
    }
}