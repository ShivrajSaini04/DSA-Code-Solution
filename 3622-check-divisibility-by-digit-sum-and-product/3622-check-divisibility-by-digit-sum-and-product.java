class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        long product = 1;
        long sum = 0;

        while (temp!=0){
            long rem = temp % 10;
            sum += rem;
            product *= rem;
            temp /= 10;
        }

        return (n % (int) (sum + product) == 0);
    }
}