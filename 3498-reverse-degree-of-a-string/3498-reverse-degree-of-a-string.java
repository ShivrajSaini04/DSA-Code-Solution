class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;

        for (int i=1;i<=n;i++){
            int idx =(int) s.charAt(i-1) - 'a';
            sum += (26 - idx) * i ;
        }
        return sum;
    }
}