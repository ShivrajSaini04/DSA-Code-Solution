class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0;
        int[] freq = new int[26];
        int max = 0;
        int n = s.length();
        int len = 0;

        while(j < n){
            char ch = s.charAt(j);
            freq[ch -'A']++;

            max =  Math.max(max , freq[ch -'A'] );

            if ((j - i + 1) - max > k) {
                freq[s.charAt(i) -'A']--;
                i++;
            }

            len =  Math.max(len , j - i + 1 );
            j++;
        }
        
        return len;
    }
}