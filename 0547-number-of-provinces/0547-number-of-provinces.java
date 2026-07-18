class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            if (!visit[i]){
                bfs(i,visit,isConnected);
                count++;
            }
        }
        return count;
    }

    void bfs(int i, boolean[] visit ,int[][] adj){
        int n = adj.length;
        Queue<Integer> q = new LinkedList<>();
         q.add(i);
        visit[i] = true;
        while(q.size()>0){
            int front = q.poll();
            for(int j=0;j<n;j++){
                if (adj[front][j] == 1 && !visit[j]){
                    q.add(j);
                    visit[j] = true;
                }
            }
        }
    }
}