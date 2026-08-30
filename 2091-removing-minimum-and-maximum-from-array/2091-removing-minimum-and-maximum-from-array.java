class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n==1) return 1;
        int minIdx = 0 , maxIdx = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i=0;i<n;i++){
            if (nums[i] > max ) {
                max = nums[i];
                maxIdx = i;
            }
            if (nums[i] < min ) {
                min = nums[i];
                minIdx = i;
            }
        }
        // HAME FIND KARNA HAI MIN AND MAX , yaha par ab teen scenarios hai 
        // 1 , remove element , 0 to first  && sec to last 
        int left = Math.max(maxIdx,minIdx) + 1;
        int right = n- Math.min(maxIdx,minIdx);
        int leftRig =0;
        if (minIdx < maxIdx)  leftRig = (minIdx + 1 ) + (n - maxIdx);
        else leftRig = (maxIdx + 1 ) + (n - minIdx);
        int ans = Math.min(leftRig , Math.min(left , right));
        return ans;
    }
}