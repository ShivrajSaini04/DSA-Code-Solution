class Triplet {
    TreeNode node;
    int row;
    int col;

    Triplet(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer ,PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root , 0,0));

        while(q.size()> 0 ) {
            Triplet temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            TreeNode node = temp.node;

           map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left!= null)  q.add(new Triplet(node.left ,row + 1 ,col - 1));
            if (node.right!= null) q.add(new Triplet(node.right , row + 1 ,col + 1));
        }
        
         for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}    