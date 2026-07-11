class Solution {

    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        // Agar saare elements use ho gaye
        // ya current value iss subtree ki range ke bahar hai
        if (idx == preorder.length || preorder[idx] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);

        // Left subtree ki  values < root.val
        root.left = build(preorder, root.val);

        // Right subtree values > root.val
        root.right = build(preorder, bound);

        return root;
    }
}