class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visit = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        bfs(source,adj,visit);
        return visit[destination];
    }

    void bfs(int start , List<List<Integer>> adj , boolean[] visit){
         Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        while(q.size() > 0){
          int temp = q.poll();
          for(int ele : adj.get(temp)){
           if (!visit[ele]){
               q.add(ele);
               visit[ele] = true;
           }
          }
        }
    }
}