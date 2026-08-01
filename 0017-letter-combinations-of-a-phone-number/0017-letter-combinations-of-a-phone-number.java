class Solution {

    String[] keypad = {
    "",      // 0
    "",      // 1
    "abc",   // 2
    "def",   // 3
    "ghi",   // 4
    "jkl",   // 5
    "mno",   // 6
    "pqrs",  // 7
    "tuv",   // 8
    "wxyz"   // 9
};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        helper(0 , digits ,  new StringBuilder(), list);
        return list;
    }

    void helper(int idx, String digit , StringBuilder str ,List<String> list){
          if (idx == digit.length()){
            list.add(str.toString());
            return;
          }

          String currNum = keypad[digit.charAt(idx) - '0'];

          for(char ch : currNum.toCharArray()){
            str.append(ch);
             helper(idx + 1, digit , str, list);
             // backtracking 
             str.deleteCharAt(str.length() -1);
          }
    }
}