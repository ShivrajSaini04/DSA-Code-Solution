class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int i = 0, j = 0;

        for (j = 0; j < n; j++) {

            if (nums[j] == 0) k--;

            while (k < 0) {
                if (nums[i] == 0) k++;
                i++;
            }

            max = Math.max(max, j - i +1);
        }

        return max;
    }
}