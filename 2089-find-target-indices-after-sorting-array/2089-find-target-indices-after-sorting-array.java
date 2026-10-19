class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int freq = 0;
        int idx = -1;
        int max = 0;
        int min = 0;
        List<Integer> list = new ArrayList<>();

        for (int i =0;i<nums.length;i++) {
            if (nums[i] == target) {
                if (idx == -1) idx = i;
                freq++;
            }
            if (idx == -1 && nums[i] > target) max++;
            if (idx != -1 && nums[i] < target) min++;
        }

        idx = idx + min - max;

        for (int i = 1; i<= freq; i++) list.add(idx++);

       return list;    
    }
}