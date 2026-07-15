class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int check = arr[sr][sc];
       if (check != color) fill(arr, sr,sc,check ,color);
        return arr;
    }

    void fill(int[][] arr, int r, int c,int check, int color){
         if (r < 0 || c < 0 || r >= arr.length || c >= arr[0].length)
            return;

        if (arr[r][c] != check) return;
        
        arr[r][c] = color;
        
        fill(arr, r-1,c,check ,color);
        fill(arr, r+1,c,check ,color);
        fill(arr, r,c-1,check ,color);
        fill(arr, r,c+1,check ,color);
    }   
}