class Solution {
    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int ele : nums){
            small = Math.min(small,ele);
            largest = Math.max(largest , ele);
        }

        return  gcd(small, largest);
    }

    public  int gcd(int a, int b) {
        while ( b % a != 0){
            int r  = b % a;
            b = a;
            a = r;
        }
        return a;
    }
}