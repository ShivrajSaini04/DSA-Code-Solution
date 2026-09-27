
class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save the current string
                stack.push(current.toString());

                // Start a new substring
                current.setLength(0);

            } else if (ch == ')') {
                // Reverse the current substring
                current.reverse();

                // Get the previous string
                String previous = stack.pop();

                // Combine previous + reversed current
                current.insert(0, previous);

            } else {
                // Add normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}
