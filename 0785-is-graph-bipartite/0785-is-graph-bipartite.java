class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visit = new int[n];
        Arrays.fill(visit, -1);
        for(int i=0;i<n;i++){
            if (visit[i] == -1) 
              if ( !bfs(i, graph, visit))  return false;
        }
        return true;
    }

     boolean bfs(int start, int[][] graph, int[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = 1;
        while (q.size() > 0) {
            int temp = q.poll();
            int color = visit[temp];
            for(int ele : graph[temp]){
                if (visit[ele] == visit[temp]) return false;

                if (visit[ele] == -1){
                    visit[ele] = 1 - color;
                    q.add(ele);
                }
            }
        }
        return true;
    }
}