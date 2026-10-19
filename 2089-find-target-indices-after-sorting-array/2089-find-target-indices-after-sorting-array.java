class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int freq = 0;
        int min = 0;
        List<Integer> list = new ArrayList<>();

        for (int i =0;i<nums.length;i++) {
            if (nums[i] == target) freq++;
            else if (nums[i] < target) min++;
        }

        for (int i = 0; i< freq; i++) list.add( min + i);

       return list;    
    }
}