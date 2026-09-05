class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suff = new int[n +1];
        suff[n] = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;

        for (int i =n-1; i>=0; i--){
            suff[i] = Math.min( nums[i] , suff[i+1]);
        }
       
        for (int i =0; i<n; i++){
            max = Math.max(max , nums[i]);

            if ( (max - suff[i]) <= k) return i;
        }
        return -1;
    }
}