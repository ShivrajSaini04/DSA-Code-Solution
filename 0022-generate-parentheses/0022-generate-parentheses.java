class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0,0,n,new StringBuilder() , ans);
        return ans;
    }

    void helper(int o , int c , int n , StringBuilder str , List<String> ans){
        if (str.length() == 2 * n) {
            ans.add(str.toString());
            return;
        }

        if (o < n ){
            helper(o+1,c,n , str.append('(') , ans);
            str.deleteCharAt(str.length() - 1);
        } 
          
        if (c < o){
            helper(o,c+1,n , str.append(')') , ans);
            str.deleteCharAt(str.length() - 1);
        } 
    }
}