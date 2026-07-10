class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return Builder(0,n-1,nums);
    }

    public TreeNode Builder(int low , int high ,int[] nums){
        int n = nums.length;
        if (low > high ) return null;
        int mid = (low + high )/ 2;
        TreeNode root = new TreeNode(nums[mid]);
         root.left =  Builder(low,mid-1,nums);
         root.right =  Builder(mid + 1 , high ,nums);
         return root;
    }
}