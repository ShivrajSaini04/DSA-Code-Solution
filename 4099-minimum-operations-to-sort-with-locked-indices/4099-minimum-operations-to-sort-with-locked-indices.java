class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (locked[i] == 1 && (nums[i] != i + 1 || max != i + 1))
                ans++;
        }
        if (ans > k)
            return -1;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] > nums[j])
                    ans++;
        return ans;
    }
}