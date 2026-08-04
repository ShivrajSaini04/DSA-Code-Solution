class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n== 1 || (n== 2 && nums[0] != nums[1])) return n;

        int i=2;

        for(int j=2;j<nums.length;j++){
            if (nums[j] != nums[i -2] ){
               nums[i++]= nums[j];
            }
        }
        return i;
    }
}