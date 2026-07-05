class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node , int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new ArrayDeque<>();
        int max = 0;
        q.add(new Pair(root , 0));

        while(q.size() > 0){
            int n = q.size();
            int rig = q.getLast().idx;
            int left = q.getFirst().idx;
             
             max = Math.max(max , rig - left +1 );

             while(n!=0){
                Pair temp = q.poll();
                int idx = temp.idx;
                TreeNode node = temp.node;
                if (node.left!=null) q.add(new Pair(node.left , 2 * idx + 1));
                if (node.right!=null) q.add(new Pair(node.right , 2 * idx + 2));
                n--;
             }
        }
        return max;
    }
}