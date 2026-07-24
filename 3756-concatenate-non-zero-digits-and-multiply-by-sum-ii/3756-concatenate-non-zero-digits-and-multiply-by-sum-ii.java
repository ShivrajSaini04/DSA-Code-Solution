class Solution {

    int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        long[] sum = new long[n + 1];
        int[] count = new int[n + 1];
        long[] pre = new long[n + 1];
        long[] pow = new long[n + 1];

        pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {

            int d = s.charAt(i) - '0';

            sum[i + 1] = sum[i] + d;
            count[i + 1] = count[i];
            pre[i + 1] = pre[i];

            if (d != 0) {
                count[i + 1]++;
                pre[i + 1] = (pre[i] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long digitSum = sum[r + 1] - sum[l];

            int len = count[r + 1] - count[l];

            long num = (pre[r + 1] - (pre[l] * pow[len]) % MOD + MOD) % MOD;

            ans[i] = (int) ((digitSum * num) % MOD);
        }

        return ans;
    }
}

// class Solution {
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int n = queries.length;
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++) {
//             int l = queries[i][0];
//             int r = queries[i][1];
//             long num = 0;
//             long sum = 0;

//             for (int j = l; j <= r; j++) {

//                 int d = s.charAt(j) - '0';

//                 if (d == 0) continue;

//                 sum += d;
//                 num = (num * 10 + d) % 1000000007;
//             }
//             res[i] = (int) ((sum * num) % 1000000007);
//         }
//         return res;
//     }
// }