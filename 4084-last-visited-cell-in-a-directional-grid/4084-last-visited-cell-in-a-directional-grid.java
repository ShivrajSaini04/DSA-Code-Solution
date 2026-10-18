class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        int[] ans = new int[2];
        int i =0,j=0;

        while (true){
            visit[i][j] = true;
            ans[0]=i;
            ans[1]=j;

            int[] idx = idx(grid[i][j],i,j);
            i = idx[0];
            j= idx[1];

            if (i < 0 || i >= n || j < 0 || j >= m || visit[i][j]) 
            return ans;  
            
        }
    }

    int[] idx (char ch , int i , int j ){
        if (ch == 'R') return new int[]{i,j+1};
        else if (ch == 'L') return new int[]{i,j-1};
        else  if (ch == 'U') return new int[]{i-1,j};
        else return new int[]{i+1,j};
    }
}