class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int count = 0, len = -1;
        int i = 0, j = 0;
        int[] idx = new int[2];

        while (j < n ) {
            if (s.charAt(j) == '1')
                count++;

            if (count == k) {

                while (i <= j && s.charAt(i) == '0') {
                    i++;
                }
                int currLen = j - i + 1;
                if (len == -1 || currLen < len) {
                    len = (j - i) + 1;
                    idx[0] = i;
                    idx[1] = j;
                }
                else if (currLen == len) {
                    String curr = s.substring(i, j + 1);
                    String best = s.substring(idx[0], idx[1] + 1);

                    if (curr.compareTo(best) < 0) {
                        idx[0] = i;
                        idx[1] = j;
                    }
                } 
                if (s.charAt(i) == '1') {
                    count--;
                    i++;
                }
            }

            j++;
        }

        if (len != -1)  return s.substring(idx[0], idx[1] + 1);
        
        return "";
    }
}