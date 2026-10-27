class Solution {
    public String[] createGrid(int m, int n) {
        List<String> list = new ArrayList<>();
        char[][] mat = new char[m][n];

        for (int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if (i==0 || j == n-1) mat[i][j] = '.';
                else mat[i][j] = '#';
            }
        }
        
        int idx = 0;
        for (char[] row : mat) {
            String str = new String(row);
            list.add(str);
        }

        return list.toArray(new String[0]);
    }
}