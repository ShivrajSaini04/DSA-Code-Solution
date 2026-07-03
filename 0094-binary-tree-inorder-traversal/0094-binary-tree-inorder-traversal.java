
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        inorder(root , list);
        return list;
    }

    void inorder(TreeNode root , List<Integer> list){
        if (root == null) return;
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }
}