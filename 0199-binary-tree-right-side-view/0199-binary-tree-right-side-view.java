
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
         dfs(root, list, 0);
        return list;
    }
    void dfs(TreeNode root, List<Integer> list, int i) {
        if (root == null)
            return;
       if (i==list.size()) 
           list.add(i, root.val);

        dfs(root.right, list, i + 1);
        dfs(root.left, list, i + 1);
    }
}