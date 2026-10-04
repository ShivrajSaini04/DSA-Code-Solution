class Solution {
    public int minRotations(String s) {
        int pos = 0;
        int count = 0;

        for(int ch : s.toCharArray()){
            int num = ch - '0';

            int diff = Math.abs(pos - num);
            int cf =  10 - diff;      // ( num + 9) % 9;

          count += Math.min(diff , cf);
            pos = num;
        }
        return count;
    }
}