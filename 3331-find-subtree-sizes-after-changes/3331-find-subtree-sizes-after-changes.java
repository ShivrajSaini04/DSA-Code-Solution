
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }

        int[] newParent = new int[n];
        int[] last = new int[26];
        int[] saved = new int[n];

        Arrays.fill(last, -1);

        // Iterative DFS with backtracking
        int[] nodes = new int[2 * n + 1];
        int[] state = new int[2 * n + 1];

        int top = 0;
        nodes[top] = 0;
        state[top++] = 0;

        while (top > 0) {
            int node = nodes[--top];
            int type = state[top];

            int c = s.charAt(node) - 'a';

            if (type == 0) {
                saved[node] = last[c];

                newParent[node] = (last[c] == -1)
                        ? parent[node] : last[c];

                last[c] = node;

                nodes[top] = node;
                state[top++] = 1;

                for (int child : graph[node]) {
                    nodes[top] = child;
                    state[top++] = 0;
                }
            } else {
                last[c] = saved[node];
            }
        }

        // Build modified tree
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        // Calculate subtree sizes iteratively
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int[] order = new int[n];
        int[] stack = new int[n];

        int size = 0;
        top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];
            order[size++] = node;

            for (int child : tree[node]) {
                stack[top++] = child;
            }
        }

        // Reverse order: children before parents
        for (int i = size - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
