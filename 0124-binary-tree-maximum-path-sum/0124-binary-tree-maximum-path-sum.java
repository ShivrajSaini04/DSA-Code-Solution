class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    int  solve(TreeNode root ) {
        if (root == null) return 0;

        int leftSum =  Math.max(0,solve(root.left));
        int rightSum =  Math.max(0,solve(root.right));

        maxSum = Math.max( maxSum , leftSum + root.val + rightSum);

        return root.val + Math.max(leftSum , rightSum);
    }
}