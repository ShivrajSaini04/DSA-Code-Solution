class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        // for row 
        for (int i=0;i<n;i++){
            int k = rowShift[i] % n;
            int[] temp = new int[n];
            for (int j=0;j<n;j++){
                temp[j] = grid[i][ ( j+ k) %n];
            } 
            grid[i] = temp;
        }

        // for row 
        for (int i=0;i<n;i++){
            int k = colShift[i] % n;
            int[] temp =new int[n];
            for (int j=0;j<n;j++){
                temp[j] = grid[( j+ k) %n][i];
            } 
            for (int j=0;j<n;j++){
                 grid[j][i] = temp[j];
            }
            
        }
        return grid;
    }
}