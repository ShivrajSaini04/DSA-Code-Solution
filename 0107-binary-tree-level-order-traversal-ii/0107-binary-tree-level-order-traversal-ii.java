
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        q.add(root);
        while(q.size() > 0){
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            while(n!=0){
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
                n--;
             }
             ans.add(list);
        }
        Collections.reverse(ans);
        return ans;
    }
}