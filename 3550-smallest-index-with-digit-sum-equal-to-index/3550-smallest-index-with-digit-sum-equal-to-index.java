class Solution {
    public int smallestIndex(int[] nums) {
       int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i=0;i<n;i++){
            int x = nums[i];
            int sum = 0;

            while (x!=0){
                sum += x % 10;
                x /= 10;
            }
            if ((sum < n && sum < ans) && nums[sum] == nums[i]) ans = sum;
        }
         if (ans >= n) return -1;
        return ans;
    }
}