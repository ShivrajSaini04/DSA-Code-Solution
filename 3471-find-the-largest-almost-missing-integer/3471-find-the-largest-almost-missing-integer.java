class Solution {
    public int largestInteger(int[] nums, int k) {
         int n = nums.length;
         int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        if (k==1){
            for(int ele : nums){
                if (ele > ans  && map.get(ele) == 1) ans = ele;
            }
            return ans;
        } 

        else if ( k == n){
            for(int ele : nums){
                if (ele > ans ) ans = ele;
            }
            return ans;
        }
        else {
            int fir = nums[0];
            int last = nums[n-1];
            if (map.get(fir) == 1 && map.get(last) > 1) ans =fir;
            else if (map.get(last) == 1 && map.get(fir) > 1) ans = last;
            else if (map.get(fir) == 1 && map.get(last) == 1)
                ans = Math.max(fir,last);
        }
        return ans;
    }
}