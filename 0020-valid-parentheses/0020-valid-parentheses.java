class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length()%2==1) return false ;  // odd length always not valid
         for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (st.isEmpty() || ch =='(' || ch == '[' || ch== '{' )  st.push(ch);
            else {
                if (ch ==')' && st.peek() == '(' || ch =='}' && st.peek() == '{' ||
               ch ==']' && st.peek() == '[' )  st.pop();
                else return false;
            }
         }
         if (!st.isEmpty()) return false;
         return true;
    }
}