class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int n=nums.length-k;
        int arr[] = new int [n+1];
        for (int i=0;i<nums.length;i++){

           while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.removeLast();

           q.addLast(i);

           if (q.getFirst() + k == i) q.removeFirst();
           if (i >= k-1 ) arr[i-k+1] = nums[q.getFirst()]; 
        }
       return arr;
    }
}