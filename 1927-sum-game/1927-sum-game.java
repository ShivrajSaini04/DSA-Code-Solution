class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        // Alice can force a win if the number of '?' is odd
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // Alice wins if the existing difference cannot be balanced
        return diff != -9 * (qDiff / 2);
    }
}