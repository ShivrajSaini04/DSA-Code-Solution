
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 1: Count frequencies of factors
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 2: Calculate gain for every factor
        int[] gain = new int[maxFactor + 1];

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--;
        }

        // Step 3: Group bonus purchases by price
        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            if (gain[factor] > 0 && price < 2L * minPrice) {
                map.put(price,
                    map.getOrDefault(price, 0L) + gain[factor]);
            }
        }

        // Step 4: Buy cheapest bonus items first
        long remaining = budget;
        long ans = 0;

        for (int price : map.keySet()) {

            if (remaining < price) break;

            long count = Math.min(
                remaining / price,
                map.get(price)
            );

            ans += count * 2;
            remaining -= count * price;
        }

        // Step 5: Buy normal items using remaining budget
        ans += remaining / minPrice;

        return (int) ans;
    }
}
