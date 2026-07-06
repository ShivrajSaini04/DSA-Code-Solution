
class Solution {
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if (root == null ) return true;
        flag = true;
        level(root);
        return flag;
    }

     int level(TreeNode root){
        if(root == null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        if (Math.abs(left - right) > 1) flag = false;
        return 1 + Math.max(left , right);
     }
}