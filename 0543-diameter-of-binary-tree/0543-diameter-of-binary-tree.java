class Solution {
    static int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        level(root);
        return max;
    }

     int level(TreeNode root){
        if(root == null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left , right);
     }
}