class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        st.push(nums2[n-1]);
        map.put(nums2[n-1],-1);
        for(int i= n-2; i>=0;i--){
 
           while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();

           if (st.isEmpty()) {
            map.put(nums2[i] , -1);
             st.push(nums2[i]);
           }
           else {
            map.put(nums2[i],st.peek());
            st.push(nums2[i]);
           }
        }

        for(int i=0;i<nums1.length;i++){
                nums1[i] = map.get(nums1[i]); // because nums1 is subset of nums2
        }
        return nums1;
    }
}