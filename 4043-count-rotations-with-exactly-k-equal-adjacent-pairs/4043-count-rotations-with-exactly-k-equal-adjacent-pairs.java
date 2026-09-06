class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i=0;i<n;i++){

            int count = 0;
            String str =  s.substring(i,n) + s.substring(0,i);

            for (int j =0;j<n-1;j++){
                if (str.charAt(j) == str.charAt(j+1) ) count++;
            }
            if (count == k) ans++;
        }
        return ans;
    }
}