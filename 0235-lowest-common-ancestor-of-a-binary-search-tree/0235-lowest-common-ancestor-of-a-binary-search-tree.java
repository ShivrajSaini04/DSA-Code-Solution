

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode r1, TreeNode r2) {
         if (root.val > r2.val && root.val > r1.val) 
         return lowestCommonAncestor(root.left, r1, r2);
        else  if (root.val < r2.val && root.val < r1.val) 
        return lowestCommonAncestor(root.right, r1, r2);
          else return root;
    }
      
    //         Brute Force 
            
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    //      newnode = root;
    //     helper(root, r1, r2);
    //     return newnode;
    // }  
    //   static TreeNode newnode = new Node(0);
      
    // static void helper(TreeNode root, TreeNode r1, TreeNode r2) {
    //     if (root == null)
    //         return;
    //     if (r1.val == r2.val) {
    //         newnode = new Node(r1.val);
    //         return;
    //     }
    //     if (root.val <= r2.val && root.val >= r1.val)
    //         newnode = new Node(root.val);
    //     if (root.val < r2.val && !(root.data > r1.val))
    //         lca(root.right, r1, r2);
    //     if (!(root.val < r2.val) && (root.data > r1.val))
    //         lca(root.left, r1, r2);
    // }
}