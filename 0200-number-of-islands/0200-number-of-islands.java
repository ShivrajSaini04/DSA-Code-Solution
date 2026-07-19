class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
     public int numIslands(char[][] grid) {
           int count = 0;
           int n = grid.length;
           int m = grid[0].length;
           boolean[][] visit = new boolean[n][m];

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j] == '1' && !visit[i][j]){
                    bfs(i,j,grid,visit);
                    count++;
                }
            }
           }
           return count;
    }

     void bfs(int i, int j, char[][] grid, boolean[][] visit) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visit[i][j] = true;

        while(q.size()>0){
            Pair temp = q.remove();
            // up
            i = temp.i;
            j = temp.j;
             if (i > 0 && (grid[i-1][j]== '1' && !visit[i-1][j])){
                 q.add(new Pair(i-1, j));
                 visit[i-1][j] = true;
             }
             // down
             if (i < n-1 && (grid[i + 1][j] == '1' && !visit[i + 1][j])) {
                 q.add(new Pair(i + 1, j));
                 visit[i + 1][j] = true;
             }
             // left
             if ( j > 0 && (grid[i][j -1 ] == '1' && !visit[i][j - 1])) {
                 q.add(new Pair(i, j - 1));
                 visit[i][j -1 ] = true;
             }
             // right
             if (j < m - 1 && (grid[i][j + 1] == '1' && !visit[i][j + 1])) {
                 q.add(new Pair(i, j + 1));
                 visit[i][j + 1] = true;
             }
        }
     }
}