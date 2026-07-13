public class Codec {
    int idx = 0;
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

    void preOrder(TreeNode root , StringBuilder sb ){
        if (root == null) return;
         sb.append(root.val).append(',');
         preOrder(root.left,sb);
         preOrder(root.right,sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return ""; 
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        idx = 0;
       String[] str = data.split(",");
        int[] preorder = new int[str.length];
        // convart string to int 
        for (int i=0;i<str.length;i++)  preorder[i] = Integer.parseInt(str[i]);
        return build(preorder, Integer.MAX_VALUE);
    }
}
