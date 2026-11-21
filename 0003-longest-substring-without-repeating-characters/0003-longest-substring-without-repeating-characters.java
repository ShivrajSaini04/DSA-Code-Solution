class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0 , j=0, n= s.length();
        int len = 0;
        HashMap<Character , Integer> map = new HashMap<>();

        while(j < n){
            char ch =  s.charAt(j);
           map.put(ch, map.getOrDefault(ch, 0) + 1);

             while  ( i < j && map.get(ch) != 1) {
                map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) - 1);
                i++;
             }

           len = Math.max(len , j - i + 1);
           j++;
        }

        return len;

    }
}