class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Valid parentheses string ki length even honi chahiye
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        // Start '(' aur end ')' hona chahiye
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int change = grid[i][j] == '(' ? 1 : -1;

                // Upar se aa rahe hain
                if (i > 0) {
                    for (int balance = 0; balance < m + n; balance++) {
                        if (dp[i - 1][j][balance]) {
                            int newBalance = balance + change;

                            if (newBalance >= 0) {
                                dp[i][j][newBalance] = true;
                            }
                        }
                    }
                }

                // Left se aa rahe hain
                if (j > 0) {
                    for (int balance = 0; balance < m + n; balance++) {
                        if (dp[i][j - 1][balance]) {
                            int newBalance = balance + change;

                            if (newBalance >= 0) {
                                dp[i][j][newBalance] = true;
                            }
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}