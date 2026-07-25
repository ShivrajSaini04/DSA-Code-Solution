
class Solution {
    public boolean canFinish(int n, int[][] edges) {
           List<List<Integer>> adj = new ArrayList<>();
          int[] ind = new int[n];
          for(int i=0;i<n;i++) adj.add(new ArrayList<>());
          for(int[] row : edges ) {
              adj.get(row[1]).add(row[0]);
              ind[row[0]]++;
          }
           // Khan's Algorithum
           Queue<Integer> q = new LinkedList<>();
           ArrayList<Integer> ans = new ArrayList<>();
           for(int i=0;i<n;i++){
            if (ind[i] == 0)  q.add(i);
           }
           
           while(q.size() > 0){
            int front = q.poll();
            ans.add(front);
           for(int ele : adj.get(front)){
                ind[ele]--;
                if (ind[ele] == 0)  q.add(ele);
            }
           }

        return ans.size() == n;
    }
}