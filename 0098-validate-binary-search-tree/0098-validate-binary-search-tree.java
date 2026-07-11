class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root , null , null);
    }
          //  -2^31 <= Node.val <= 2^31 - 1  ,  isliye  Integer use kara hai 
    boolean check(TreeNode root , Integer min , Integer max){ 

        if (root == null) return true;

        if (min != null && min >= root.val) return false;
        if (max != null && max <= root.val) return false;

        return check(root.left,min,root.val) && check(root.right, root.val , max);
    }
}