
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root == null ) return ans;
        q.add(root);
        int level  = 0;
        while(q.size() > 0){
            Deque<Integer> list = new ArrayDeque<>();
            int n = q.size();
            while(n!=0){
                TreeNode node = q.poll();
                if (level % 2 != 0) list.addFirst(node.val);
                else list.add(node.val);
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
                n--;
             }
             level++;
             ans.add(new ArrayList(list));
        }
        return ans;
    }
}