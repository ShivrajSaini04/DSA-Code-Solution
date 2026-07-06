class Pair {
    TreeNode node;
    int idx;

    Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        q.add(new Pair(root , 0));
        int level = 0;

        while(q.size() > 0){
            Pair temp = q.poll();
            int curr = temp.idx;
            TreeNode node = temp.node;
            
            if (curr != level) {
                ans.add(new ArrayList(list));
                list.clear();
                level = curr;
            }
               list.add(node.val);
                if (node.left!=null) q.add(new Pair(node.left , curr + 1));
                if (node.right!=null) q.add(new Pair(node.right , curr + 1));
             }
        ans.add(new ArrayList(list));
        return ans;
    }
}
