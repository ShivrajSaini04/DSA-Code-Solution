
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        long[] diff = new long[n];

        long sum = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }

        if (sum <= k) return 0;

        long low = 0, high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long need = 0;

            for (long d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long level = low;
        long remaining = k;

        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                remaining -= diff[i] - level;
                diff[i] = level;
            }
        }

        // Distribute remaining operations one level lower.
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == level && level > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;
        for (long d : diff) {
            ans += d * d;
        }

        return ans;
    }
}
