class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;

        int i=0, j = n-1;

        while(i<j){
           int sum = nums[i] + nums[j];

           if (sum == target ) break;
           else if (sum > target) j--;
           else i++;
        }

        return new int[]{i+1,j+1};
    }
}