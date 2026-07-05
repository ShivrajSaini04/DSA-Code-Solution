class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ans = new ArrayList<>();
       dfs(root,ans,"");
       return ans;
    }

    void dfs(TreeNode root ,  List<String> ans , String str){
         if (root == null ) return;
        if (root.left == null && root.right == null){ // leaf node
            str += root.val;
            ans.add(str);
        }
        dfs(root.left,ans,str+root.val+"->");
        dfs(root.right,ans,str+root.val+"->");
    }
}