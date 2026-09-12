class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> {
            int startA = intervals.get(a).get(0);
            int startB = intervals.get(b).get(0);

            if (startA != startB)
                return startA - startB;

            int endA = intervals.get(a).get(1);
            int endB = intervals.get(b).get(1);

            if (endA != endB)
                return endA - endB;

            return a - b;
        });

        List<Integer>[][] dp = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new ArrayList<>();
            }
        }

        long[][] score = new long[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {

            int id = idx[i];
            int end = intervals.get(id).get(1);
            int weight = intervals.get(id).get(2);

            int next = binarySearch(intervals, idx, i + 1, end);

            for (int k = 1; k <= 4; k++) {

                // Skip
                long skipScore = score[i + 1][k];
                List<Integer> skipList = dp[i + 1][k];

                // Take
                long takeScore = weight + score[next][k - 1];

                List<Integer> takeList = new ArrayList<>();
                takeList.add(id);
                takeList.addAll(dp[next][k - 1]);

                Collections.sort(takeList);

                if (takeScore > skipScore ||
                    (takeScore == skipScore &&
                     isSmaller(takeList, skipList))) {

                    score[i][k] = takeScore;
                    dp[i][k] = takeList;

                } else {
                    score[i][k] = skipScore;
                    dp[i][k] = skipList;
                }
            }
        }

        List<Integer> ans = dp[0][4];

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private int binarySearch(
        List<List<Integer>> intervals,
        Integer[] idx,
        int left,
        int end
    ) {
        int right = idx.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (intervals.get(idx[mid]).get(0) > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}