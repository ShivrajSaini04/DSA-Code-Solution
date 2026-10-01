class Solution {
    public boolean isValid(String str) {
          Stack<Character> st = new Stack<>();
        int n=str.length();
        if (n%2==1) return false ;
        for (int i=0;i<n;i++){
            char ch = str.charAt(i);
            if (ch=='(' || ch=='[' || ch=='{') {
                st.push(ch);
            }else {
                 if (st.isEmpty()) return false ;
               char top = st.pop();
                  if ((ch == ')' && top != '(') ||
            (ch == ']' && top != '[') ||
            (ch == '}' && top != '{')) 
               return false;
            }
        }
        if (st.size()!=0) return false ;
        return true ;
    }
}