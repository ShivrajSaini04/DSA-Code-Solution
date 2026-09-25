class Solution {

    String s;
    int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> set = dfs();

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }

    // expression = term (',' term)*
    private Set<String> dfs() {
        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {

            Set<String> current = new HashSet<>();
            current.add("");

            // Handle concatenation
            while (index < s.length()
                    && s.charAt(index) != ','
                    && s.charAt(index) != '}') {

                Set<String> part;

                if (s.charAt(index) == '{') {
                    index++;              // skip '{'
                    part = dfs();
                    index++;              // skip '}'
                } else {
                    part = new HashSet<>();
                    part.add(String.valueOf(s.charAt(index)));
                    index++;
                }

                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : part) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }

            // Union
            result.addAll(current);

            if (index < s.length() && s.charAt(index) == ',') {
                index++;
            }
        }

        return result;
    }
}