class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {

        int count = 0;
        int n = nums.length;

        // Find indices that must be unlocked
        boolean[] need = new boolean[n];
        int maxPrefix = 0;

        for (int i = 0; i < n - 1; i++) {
            maxPrefix = Math.max(maxPrefix, nums[i]);

            if (maxPrefix > i + 1) {
                need[i] = true;
                need[i + 1] = true;
            }
        }

        // Unlock only required indices
        for (int i = 0; i < n; i++) {
            if (need[i] && locked[i] == 1) {
                locked[i] = 0;
                count++;
            }
        }

        if (count > k) return -1;

        //  Bubble Sort logic
        for (int j = 0; j < n; j++) {
            boolean swapped = false;

            for (int i = 0; i < n - 1; i++) {

                if (locked[i] == 0 && locked[i + 1] == 0
                    && nums[i] > nums[i + 1]) {

                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;

                    count++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return count;
    }
}