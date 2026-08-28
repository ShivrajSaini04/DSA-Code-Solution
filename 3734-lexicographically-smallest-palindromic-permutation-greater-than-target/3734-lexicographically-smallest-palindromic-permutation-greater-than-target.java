class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check palindrome possibility
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) return "";

        int halfLen = n / 2;

        // Build frequency of left half
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        String targetLeft = target.substring(0, halfLen);

        // First try to make left half exactly targetLeft
        String equal = buildEqual(half, targetLeft);

        if (equal != null) {
            String ans = makePalindrome(equal, mid);

            if (ans.compareTo(target) > 0) {
                return ans;
            }
        }

        // Otherwise find smallest left half > targetLeft
        String greater = buildGreater(half, targetLeft);

        if (greater == null) return "";

        return makePalindrome(greater, mid);
    }

    // Try to create exactly targetLeft using available characters
    private String buildEqual(int[] half, String target) {

        int[] cnt = half.clone();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int c = target.charAt(i) - 'a';

            if (cnt[c] == 0) {
                return null;
            }

            cnt[c]--;
            sb.append(target.charAt(i));
        }

        return sb.toString();
    }

    // Find lexicographically smallest string > targetLeft
    private String buildGreater(int[] half, String target) {

        int m = target.length();

        // Try changing from right to left
        for (int pos = m - 1; pos >= 0; pos--) {

            int[] cnt = half.clone();
            boolean possible = true;

            // Keep prefix same
            for (int i = 0; i < pos; i++) {

                int c = target.charAt(i) - 'a';

                if (cnt[c] == 0) {
                    possible = false;
                    break;
                }

                cnt[c]--;
            }

            if (!possible) continue;

            int current = target.charAt(pos) - 'a';

            // At this position choose smallest character > target[pos]
            for (int c = current + 1; c < 26; c++) {

                if (cnt[c] == 0) continue;

                cnt[c]--;

                StringBuilder result = new StringBuilder();

                // prefix
                result.append(target, 0, pos);

                // bigger character
                result.append((char) ('a' + c));

                // smallest remaining characters
                for (int x = 0; x < 26; x++) {
                    while (cnt[x] > 0) {
                        result.append((char) ('a' + x));
                        cnt[x]--;
                    }
                }

                return result.toString();
            }
        }

        return null;
    }

    private String makePalindrome(String left, char mid) {

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != 0) {
            ans.append(mid);
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString();
    }
}