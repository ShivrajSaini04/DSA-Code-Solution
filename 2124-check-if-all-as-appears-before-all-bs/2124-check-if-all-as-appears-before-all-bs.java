class Solution {
    public boolean checkString(String s) {
        boolean flag = false ;
        int n = s.length();
        for (char ch : s.toCharArray()){
            if (ch == 'b')  flag = true;
            if (ch == 'a' && flag  ) return false;
        }
        return true;
    }
}