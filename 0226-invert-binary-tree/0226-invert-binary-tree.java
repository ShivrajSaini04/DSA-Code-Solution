
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null ) return null;
        invert(root);
        return root;
    }

    void invert(TreeNode root){
        if (root == null) return;

        TreeNode  temp =  (root.right != null) ? root.right : null;
        root.right =(root.left != null) ? root.left : null;
        root.left = temp ;
        invert(root.left) ;
        invert(root.right);

    }
}