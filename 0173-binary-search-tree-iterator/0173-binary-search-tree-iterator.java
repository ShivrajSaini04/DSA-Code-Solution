class BSTIterator {

    void pushSubTree(TreeNode curr){
        while (curr != null) {
            st.push(curr);
            curr = curr.left;
        }
    }

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushSubTree(root);
    }

    public int next() {
        TreeNode top = st.pop();
        
        if (top.right != null) {
            pushSubTree(top.right);
        }

        return top.val;
    }
    
    public boolean hasNext() {
         return !st.isEmpty();
    }
}
