class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0,0,n,"" , ans);
        return ans;
    }

    void helper(int o , int c , int n , String str , List<String> ans){
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        if (o < n ) helper(o+1,c,n , str + "(" , ans);
          
        if (c < o) helper(o,c+1,n , str + ")" , ans);
    }
}