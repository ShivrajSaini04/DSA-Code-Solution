class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] node : invocations) {
            adj.get(node[0]).add(node[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visit[k] = true;

        while (q.size() > 0) {
            int node = q.poll();

            for (int ele : adj.get(node)) {
                if (!visit[ele]) {
                    visit[ele] = true;
                    q.add(ele);
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int ele : adj.get(i)) {
                if (!visit[i] && visit[ele]) {
                    flag = true;
                    break;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (flag || !visit[i]) {
                list.add(i);
            }
        }
        return list;
    }
}