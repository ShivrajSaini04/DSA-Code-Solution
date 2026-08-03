class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()){
            freq[(int) ch - 'a']++;
        }

        Arrays.sort(freq);
        int ans = 0;
        int count = 1;

        for(int i=25; i>=0; i--){
            if (freq[i] == 0) return ans;

            if (count <= 8 ) ans += freq[i] * 1;
            else if ( count <= 16 ) ans += freq[i] * 2;
            else if ( count <= 24 ) ans += freq[i] * 3;
            else ans += freq[i] * 4;
            count++;
        }

        return ans;
    }
}