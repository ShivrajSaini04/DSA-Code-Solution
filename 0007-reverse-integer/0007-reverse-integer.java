class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int rem = x % 10;

            // for positive overflow 
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && rem > 7)) 
                return 0;
            
            // for negative overflow
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && rem < -8))
                return 0;
            
            rev = (10 * rev) + rem;
            x /= 10;

        }
        return rev;
    }
}