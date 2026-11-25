
import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int[] sa = buildSuffixArray(nums);
        int[] rank = new int[n];
        int[] lcp = new int[n];

        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        // Build LCP array using Kasai's algorithm
        int k = 0;

        for (int i = 0; i < n; i++) {
            int r = rank[i];

            if (r == 0) continue;

            int j = sa[r - 1];

            while (i + k < n && j + k < n &&
                   nums[i + k] == nums[j + k]) {
                k++;
            }

            lcp[r] = k;

            if (k > 0) k--;
        }

        // Find minimum unique subarray length
        int ans = n;

        for (int i = 0; i < n; i++) {
            int maxLcp = lcp[i];

            if (i + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }

            int uniqueLength = maxLcp + 1;

            if (uniqueLength <= n - sa[i]) {
                ans = Math.min(ans, uniqueLength);
            }
        }

        return ans;
    }

    private int[] buildSuffixArray(int[] nums) {
        int n = nums.length;
        int N = n + 1;

        int[] s = new int[N];

        for (int i = 0; i < n; i++) {
            s[i] = nums[i];
        }

        s[n] = 0;

        int[] p = new int[N];
        int[] c = new int[N];

        int alphabet = Math.max(N, 100002);
        int[] cnt = new int[alphabet];

        for (int x : s) {
            cnt[x]++;
        }

        for (int i = 1; i < alphabet; i++) {
            cnt[i] += cnt[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            p[--cnt[s[i]]] = i;
        }

        c[p[0]] = 0;
        int classes = 1;

        for (int i = 1; i < N; i++) {
            if (s[p[i]] != s[p[i - 1]]) {
                classes++;
            }
            c[p[i]] = classes - 1;
        }

        int[] pn = new int[N];
        int[] cn = new int[N];

        for (int len = 1; len < N; len *= 2) {

            for (int i = 0; i < N; i++) {
                pn[i] = p[i] - len;

                if (pn[i] < 0) {
                    pn[i] += N;
                }
            }

            Arrays.fill(cnt, 0, classes, 0);

            for (int x : pn) {
                cnt[c[x]]++;
            }

            for (int i = 1; i < classes; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int x = pn[i];
                p[--cnt[c[x]]] = x;
            }

            cn[p[0]] = 0;
            int newClasses = 1;

            for (int i = 1; i < N; i++) {
                int cur = p[i];
                int prev = p[i - 1];

                int mid = (cur + len) % N;
                int midPrev = (prev + len) % N;

                if (c[cur] != c[prev] ||
                    c[mid] != c[midPrev]) {
                    newClasses++;
                }

                cn[cur] = newClasses - 1;
            }

            int[] temp = c;
            c = cn;
            cn = temp;

            classes = newClasses;

            if (classes == N) break;
        }

        int[] sa = new int[n];

        for (int i = 1; i < N; i++) {
            sa[i - 1] = p[i];
        }

        return sa;
    }
}
