class Solution {

    int ans = 0;

    class Info {
        boolean isBST;
        int sum;
        int min;
        int max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(true, 0,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE);
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        if (left.isBST &&
            right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            int sum = left.sum + right.sum + root.val;

            ans = Math.max(ans, sum);

            int mn = Math.min(left.min, root.val);
            int mx = Math.max(right.max, root.val);

            return new Info(true, sum, mn, mx);
        }

        return new Info(false, 0, 0, 0);
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
}