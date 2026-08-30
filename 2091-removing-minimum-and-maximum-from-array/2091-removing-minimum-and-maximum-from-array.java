class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n==1) return 1;
        
        int[] idx = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i=0;i<n;i++){
            if (nums[i] > max ) {
                max = nums[i];
                idx[1] = i;
            }
            if (nums[i] < min ) {
                min = nums[i];
                idx[0] = i;
            }
        }
        // HAME FIND KARNA HAI MIN AND MAX , yaha par ab teen scenarios hai 
        // 1 , remove element , 0 to first  && sec to last 
        // 2 , remove all element  from right side
        // 3,  remove all element  from left side

         int minIdx = Math.min(idx[0], idx[1]);
        int maxIdx = Math.max(idx[0], idx[1]);
         
         int left = maxIdx + 1;
         int right = n - minIdx;
         int leftRig = (minIdx + 1) + (n - maxIdx);
        
        
        return Math.min(leftRig , Math.min(left , right));
    }
}