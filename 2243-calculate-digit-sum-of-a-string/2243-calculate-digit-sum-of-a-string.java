class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        if (n <= k) return s;
        StringBuilder ans = new StringBuilder(s);
        StringBuilder str = new StringBuilder();

        while(ans.length() > k){
            int i=0;

            while(i < ans.length() ){
                int sum = 0;
                int j = i;
                while(j < ans.length() && j < i+k ){
                    sum += ans.charAt(j) - '0';
                    j++; 
                }
                str.append(sum);
                i = j;
            }
            ans.setLength(0);
            ans.append(str);
            str.setLength(0);
        }
        return ans.toString();
    }
}