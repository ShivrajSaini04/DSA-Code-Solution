class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] visit = new boolean[26];
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char ch : word.toCharArray())
            set.add(ch);

        for (char ch : word.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                
                char capi = Character.toUpperCase(ch);
                if (set.contains(capi)) {
                    count++;
                    set.remove(capi);
                }
            }
        }
        return count;
    }
}