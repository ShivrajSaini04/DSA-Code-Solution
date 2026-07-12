class Solution {
     int temp=0;
     int ans =0;
    public int kthSmallest(TreeNode root, int k) {
        temp=k;
        ans=-1;
        inoerder(root);
        return ans ;
    }
    void inoerder(TreeNode root) {
        if (root == null)  return;
        inoerder(root.left);
        temp--;
        if (temp==0) ans = root.val;
        inoerder(root.right);
    }
}