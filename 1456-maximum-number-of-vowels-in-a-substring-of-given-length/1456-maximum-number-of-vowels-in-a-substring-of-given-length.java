class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int currCount =0;
        
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) currCount++;
        }
          int maxCount = currCount;

        for(int i=k;i<n;i++){
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) currCount++;
            ch = s.charAt(i-k);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) currCount--;  
            maxCount = Math.max( currCount , maxCount);
            if (maxCount == k) return k;
        }

        return  maxCount;
    }
}