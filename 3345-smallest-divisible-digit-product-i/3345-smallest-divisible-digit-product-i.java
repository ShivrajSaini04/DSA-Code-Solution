class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int product = digitProduct(n);
            if (product % t == 0) return n;
            else n++;
        }
    }

    int digitProduct(int n ){
        int pro = 1;
        while(n!=0){
            pro *= (n%10);
            n /= 10;
        }
        return pro;
    }
}