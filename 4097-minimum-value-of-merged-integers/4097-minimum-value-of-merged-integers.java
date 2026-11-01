class Solution {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int digit = 0;
        int multi = 1;

        for (int i=0;i<n;i+=2){
            int fir = nums[i];
            int sec = nums[i+1];
            while(sec != 0){
                int rem = sec % 10;
                digit = (rem * multi) + digit ;
                sec /= 10;
                multi *= 10;
            }

            while(fir != 0){
                int rem = fir % 10;
                digit = (rem * multi) + digit ;
                fir /= 10;
                multi *= 10;
            }

            ans = Math.min(ans , digit);
            digit = 0;
            multi = 1;
        }

        return ans;
    }
}