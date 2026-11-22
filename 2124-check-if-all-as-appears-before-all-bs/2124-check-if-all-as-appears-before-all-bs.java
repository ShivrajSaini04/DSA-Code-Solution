class Solution {
    public boolean checkString(String s) {
        boolean flag = false ;
        int n = s.length();
        for (int i=0;i<n;i++){
            if (s.charAt(i) == 'b')  flag = true;
            else if (s.charAt(i) == 'a' && flag  ) return false;
        }
        return true;
    }
}