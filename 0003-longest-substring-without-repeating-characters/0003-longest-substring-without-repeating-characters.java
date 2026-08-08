class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] arr = new boolean[128];
        int n  = s.length();
        int i=0 ,j =0 , max =0 ;
        while(i<n){
            char ch = s.charAt(i);

            while( arr[ch]) {
                arr[s.charAt(j++)] = false;
            }

           arr[ch] = true;
           max = Math.max(max , i-j +1);
           i++;
        }

        return max;
    }
}