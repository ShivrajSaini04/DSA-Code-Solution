class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for (int i=0;i<words.length;i++ ){
            String str = words[i];
            for (int j =0;j<str.length(); j++) {
                if (str.charAt(j) == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}