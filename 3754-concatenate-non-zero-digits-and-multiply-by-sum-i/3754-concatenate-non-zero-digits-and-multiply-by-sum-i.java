class Solution {
    public long sumAndMultiply(int n) {
        int num = 0;
        int sum = 0;
        int loc = 1;
        while (n !=0){
            int digit = n % 10;
            n /= 10;
            if (digit == 0) continue;
            sum += digit;
            num = (digit * loc) + num;
            loc *= 10;
        }
        return (long)num*sum;
    }
}