class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int n = nums.length;
        int countZero = 0;

        for (int ele : nums) {
            if (ele == 0) countZero++;
            else product *= ele;
        }

        if (countZero > 1) {
            Arrays.fill(nums,0);
            return nums;
        } 

        if (countZero == 1 ) {
            for (int i=0; i<n;i++){
                if (nums[i] == 0) nums[i] = product;
                else nums[i] = 0;
            }
        }
        else{
            for (int i=0; i<n;i++){
                 nums[i] = product / nums[i];
            }
        }
        return nums;
    }
}