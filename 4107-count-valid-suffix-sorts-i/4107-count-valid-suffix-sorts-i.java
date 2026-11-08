class Solution {
    public int countSuffix(int[] nums, int[] target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for (int ele : nums) {
            map.put(ele , map.getOrDefault(ele , 0) + 1);
        }

        for (int ele : target) {
            map.put(ele , map.getOrDefault(ele , 0) - 1);
        }

        for (int ele : map.values()) {
            if (ele != 0) return 0;
        }

        int k = n;

        for (int i =0;i<n;i++){
            if (nums[i] != target[i]) {
                k = i;
                break;
            }
        }

        int p = -1;

        for (int i =0;i<n-1;i++){
            if (target[i] < target[i + 1]) {
                p = i;
            }
        }

        return Math.max(0, Math.min(k , n-1) - p);
    }
}