class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
          int[] ind = new int[n];
          int[] ans = new int[n];
          for(int i=0;i<n;i++) adj.add(new ArrayList<>());
          for(int[] row : edges ) {
              adj.get(row[1]).add(row[0]);
              ind[row[0]]++;
          }
           // Khan's Algorithum
           Queue<Integer> q = new LinkedList<>();
           for(int i=0;i<n;i++){
            if (ind[i] == 0)  q.add(i);
           }
           int idx = 0;
           while(q.size() > 0){
            int front = q.poll();
            ans[idx++] = front;
            for(int ele : adj.get(front)){
                ind[ele]--;
                if (ind[ele] == 0)  q.add(ele);
            }
           }
           if (idx != n ) return new int[0];
        return ans;
    }
}