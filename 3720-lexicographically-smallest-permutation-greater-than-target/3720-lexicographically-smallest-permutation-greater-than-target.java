class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        // Count characters of s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // Try to keep same character as target
            if (freq[t] > 0) {
                ans[i] = target.charAt(i);
                freq[t]--;
                continue;
            }

            // Try to make this position greater
            int bigger = -1;

            for (int c = t + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    bigger = c;
                    break;
                }
            }

            if (bigger != -1) {
                ans[i] = (char) ('a' + bigger);
                freq[bigger]--;

                // Fill remaining characters in smallest order
                int idx = i + 1;

                for (int c = 0; c < 26; c++) {
                    while (freq[c] > 0) {
                        ans[idx++] = (char) ('a' + c);
                        freq[c]--;
                    }
                }

                return new String(ans);
            }

            /*
             * Cannot make current position greater.
             * Backtrack to previous positions.
             */
            for (int j = i - 1; j >= 0; j--) {

                // Put back the character used at j
                freq[ans[j] - 'a']++;

                int prev = target.charAt(j) - 'a';

                // Try a character greater than target[j]
                for (int c = prev + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[j] = (char) ('a' + c);
                        freq[c]--;

                        // Fill rest with smallest characters
                        int idx = j + 1;

                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans[idx++] = (char) ('a' + x);
                                freq[x]--;
                            }
                        }

                        return new String(ans);
                    }
                }
            }

            return "";
        }

        /*
         * If we matched the complete target,
         * we still need a permutation strictly greater.
         */
        for (int j = n - 1; j >= 0; j--) {

            freq[ans[j] - 'a']++;

            int prev = target.charAt(j) - 'a';

            for (int c = prev + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[j] = (char) ('a' + c);
                    freq[c]--;

                    int idx = j + 1;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans[idx++] = (char) ('a' + x);
                            freq[x]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}