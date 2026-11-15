class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i=0;i<n;i++){
            int and = nums[i];
            int min = nums[i];
            for(int j=i+1;j<n;j++){
                min = Math.min(nums[j] , min);
               and = and & nums[j];
                if (and == min ) count++;
            }
        }
        return (n + count);
    }
}