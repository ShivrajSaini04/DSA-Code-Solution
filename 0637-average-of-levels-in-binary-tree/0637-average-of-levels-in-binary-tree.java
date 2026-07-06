
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
         List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int n = q.size();
            double sum = 0;
            int count = 0;
            while(n!=0){
                TreeNode node = q.poll();
                sum += node.val;
                count++;
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
                n--;
             }
            list.add(sum / count);
        }
        return list;
    }
}