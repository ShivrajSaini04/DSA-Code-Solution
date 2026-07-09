
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Approach  
        // 1.  first invert left tree / right tree 
        // 2.  check left tree and right tree is same (true) else false
         if (root.left==null && root.right==null) return true;
         root.left = invertTree(root.left);
         return isSameTree(root.left , root.right);
    }

    public TreeNode invertTree(TreeNode root) {
       // if (root.left==null && root.right==null) return root;
        if (root==null) return root;
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
         if (p.val!=q.val) return false ;
         return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}