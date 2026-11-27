
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        for (int i = 0; i <= budget; i++) {
            dp[i] = i / minPrice;
        }

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    count++;
                }
            }

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + count);
            }
        }

        return dp[budget];
    }
}
