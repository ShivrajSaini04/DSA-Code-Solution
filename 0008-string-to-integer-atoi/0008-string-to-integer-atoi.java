class Solution {
    public int myAtoi(String s) {
        boolean sign = false;
        int num = 0;
        boolean check = false;
        for (char ch : s.toCharArray()) {
            if (!check && ch == ' ')
                continue;
            if (!check && ch == '-' ) {
                sign = true;
                check = true;
                continue;
            }
            if (!check && ch == '+' ){
                check = true;
                continue;
            }
            if (ch < '0' || ch > '9')
                return sign ? -num : num;
            int digit = ch - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            check = true;
        }
        return sign ? -num : num;
    }
}