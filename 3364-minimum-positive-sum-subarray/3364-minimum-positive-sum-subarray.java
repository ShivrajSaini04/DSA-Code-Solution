class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
         
         for(int i=0;i<n;i++){
            int sum = 0;
            int j=i;

            while (j < n){
                sum += nums.get(j);
                
                if (((j - i + 1) >= l && (j - i + 1) <= r) && sum > 0 ) {
                    min = Math.min(min,sum);
                }
                j++;
            }
         }


        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
}