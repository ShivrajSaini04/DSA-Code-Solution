class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        if (n==1) return true;
        boolean evenflag = false ;
        boolean oddflag = false ;
        int min = Integer.MAX_VALUE;
        for (int ele : nums){
            min = Math.min(min,ele);
            if (ele%2==0) evenflag = true;
            else oddflag = true;
        }
        if (min%2!=0) return true;
        if ((evenflag && !oddflag)  || (!evenflag && oddflag) ) return true;
        return false;
    }
}