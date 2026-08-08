class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] arr = new boolean[128];
        int n  = s.length();
        int i=0 ,j =0 , max =0 ;
        while(i<n){
            char ch = s.charAt(i);

           if (arr[(int) ch]) {
            max = Math.max(max , i - j);
            while( j < n && s.charAt(j) != ch) {
                 char ch1 = s.charAt(j++);
                 arr[(int) ch1] = false;
            }
            j++;
           }

           arr[(int) ch] = true;
           i++;
        }

         max = Math.max(max , i-j);
        return max;
    }
}