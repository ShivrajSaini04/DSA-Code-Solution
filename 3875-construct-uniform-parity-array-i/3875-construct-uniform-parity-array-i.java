class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int j = 0;
        for (int ele : nums1 ){
             if (ele % 2 !=  0) break;
             j++; 
        }
        for (int i = 0; i<n;i++){
            if (nums1[i] % 2 == 0 && j > n) return false;
        }

        return true;
    }
}