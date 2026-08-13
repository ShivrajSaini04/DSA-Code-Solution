class Solution {

    class Node {
        int len;
        int pref;
        int suff;
        int best;
        char leftChar;
        char rightChar;

        Node(int len, int pref, int suff, int best, char leftChar, char rightChar) {
            this.len = len;
            this.pref = pref;
            this.suff = suff;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    String s;

    public Node merge(Node left, Node right) {

        Node res = new Node(
            left.len + right.len,
            0,
            0,
            0,
            left.leftChar,
            right.rightChar
        );

        // Prefix
        res.pref = left.pref;

        if (left.pref == left.len &&
            left.rightChar == right.leftChar) {

            res.pref = left.len + right.pref;
        }

        // Suffix
        res.suff = right.suff;

        if (right.suff == right.len &&
            left.rightChar == right.leftChar) {

            res.suff = right.len + left.suff;
        }

        // Best
        res.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            res.best = Math.max(
                res.best,
                left.suff + right.pref
            );
        }

        return res;
    }

    public void build(int node, int l, int r) {

        if (l == r) {
            char c = s.charAt(l);

            tree[node] = new Node(
                1, 1, 1, 1, c, c
            );

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public void update(int node, int l, int r, int index, char c) {

        if (l == r) {
            tree[node] = new Node(
                1, 1, 1, 1, c, c
            );

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        this.s = s;

        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );

            ans[i] = tree[1].best;
        }

        return ans;
    }
}