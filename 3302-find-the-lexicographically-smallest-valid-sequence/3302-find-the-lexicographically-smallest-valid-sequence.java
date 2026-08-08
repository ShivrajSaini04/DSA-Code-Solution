class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];

        // last[j] = latest index in word1
        // where word2[j] can be matched,
        // while still matching word2[j+1...].
        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        // Build last[] from right to left
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        int[] ans = new int[m];

        boolean mismatchUsed = false;
        j = 0;

        // Greedy: scan word1 from left to right
        for (i = 0; i < n && j < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use the one allowed mismatch
            else if (!mismatchUsed &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;

                mismatchUsed = true;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}