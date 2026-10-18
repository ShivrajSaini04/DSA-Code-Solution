class Solution {
    public int minDeletions(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i =0; i<n;i++){
           if (i < n-1 && nums[i] == nums[i+1]) count++;
        }

        return count;
    }
}