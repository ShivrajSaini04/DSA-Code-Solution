class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    boolean flag;  // true for right 
    BSTIterator(TreeNode root , boolean flag){
        this.flag = flag;
        put(root);
    }

    void put(TreeNode curr){
         while(curr != null){
            st.push(curr);
           
            if (flag)  curr = curr.right;
            else curr = curr.left;
         }
    }

    int next(){
        TreeNode top = st.pop();
         
         if (flag) put(top.left);
         else put(top.right);

         return top.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator left = new BSTIterator(root , false);
        BSTIterator right = new BSTIterator(root , true);

        int low = left.next();
        int high = right.next();

        while(low < high) {
            int sum = low + high;
            
            if (sum == k) return true;
            else if (sum > k ) high = right.next();
            else low = left.next();
        }
        return false;
    }
}