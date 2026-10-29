import java.util.*;

class Solution {
    private int n, LOG;
    private int[] bit, tin, tout, depth, pref0;
    private int[][] up;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        LOG = 1;
        while ((1 << LOG) < n) LOG++;

        // adjacency list (array based)
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[2 * (n - 1)];
        int[] to = new int[2 * (n - 1)];
        int ec = 0;
        for (int[] e : edges) {
            to[ec] = e[1]; nxt[ec] = head[e[0]]; head[e[0]] = ec++;
            to[ec] = e[0]; nxt[ec] = head[e[1]]; head[e[1]] = ec++;
        }

        int[] cur = new int[n];
        for (int i = 0; i < n; i++) cur[i] = s.charAt(i) - 'a';

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        pref0 = new int[n];
        up = new int[LOG + 1][n];
        bit = new int[n + 2];

        // iterative DFS from root 0
        int[] par = new int[n];
        par[0] = -1;
        int[] ptr = head.clone();
        int[] stack = new int[n];
        int sp = 0, timer = 0;

        stack[sp++] = 0;
        tin[0] = ++timer;
        pref0[0] = 1 << cur[0];
        up[0][0] = 0;

        while (sp > 0) {
            int u = stack[sp - 1];
            if (ptr[u] != -1) {
                int e = ptr[u];
                ptr[u] = nxt[e];
                int v = to[e];
                if (v == par[u]) continue;
                par[v] = u;
                up[0][v] = u;
                depth[v] = depth[u] + 1;
                pref0[v] = pref0[u] ^ (1 << cur[v]);
                tin[v] = ++timer;
                stack[sp++] = v;
            } else {
                tout[u] = timer;
                sp--;
            }
        }

        for (int j = 1; j <= LOG; j++) {
            for (int v = 0; v < n; v++) {
                up[j][v] = up[j - 1][up[j - 1][v]];
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int x = Integer.parseInt(p[1]);
                int c = p[2].charAt(0) - 'a';
                int delta = (1 << cur[x]) ^ (1 << c);
                cur[x] = c;
                if (delta != 0) {
                    add(tin[x], delta);
                    add(tout[x] + 1, delta);
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);
                int mask = pref(u) ^ pref(v) ^ (1 << cur[l]);
                res.add((mask & (mask - 1)) == 0);
            }
        }
        return res;
    }

    private int pref(int v) {
        return pref0[v] ^ query(tin[v]);
    }

    private void add(int i, int val) {
        for (; i <= n; i += i & -i) bit[i] ^= val;
    }

    private int query(int i) {
        int r = 0;
        for (; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) { int t = u; u = v; v = t; }
        int diff = depth[u] - depth[v];
        for (int j = 0; j <= LOG; j++) {
            if (((diff >> j) & 1) == 1) u = up[j][u];
        }
        if (u == v) return u;
        for (int j = LOG; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }
        return up[0][u];
    }
}