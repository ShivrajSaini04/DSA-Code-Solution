class Solution {
    public boolean canAliceWin(int n) {
        // int stone = 10,
        //     k = 0;
        // while (n >= stone) {
        //     n -= stone;
        //     stone--;
        //     k++;
        // }

        // optimal solution 
        int k = (int) ((21 - Math.sqrt(441 - 8 * n)) / 2);
        
        return k % 2 == 1;
    }
}