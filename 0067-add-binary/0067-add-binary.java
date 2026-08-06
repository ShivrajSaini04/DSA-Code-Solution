class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder str = new StringBuilder();
        int i = a.length()-1 , j = b.length()-1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            str.append(sum % 2);
            carry = sum / 2;
        }
        str.reverse();
        return str.toString();
    }
}