class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int in = 0;
        int dec = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] > nums[i - 1]) count++;
            else  count = 1;

            in = Math.max(in, count);
        }

        count = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[i - 1]) count++;
            else  count = 1;

            dec = Math.max(dec, count);
        }

        return Math.max(in, dec);
    }
}