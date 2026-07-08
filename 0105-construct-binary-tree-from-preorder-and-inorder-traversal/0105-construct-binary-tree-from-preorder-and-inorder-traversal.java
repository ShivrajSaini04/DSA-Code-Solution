class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          int n = preorder.length;
          return  Builder(0,n-1,preorder,0,n-1,inorder);
    }

    public TreeNode Builder (int prelow , int prehi, int[] preorder,int inlow , int inhi, int[] inorder){
         if (prelow > prehi || inlow > inhi)  return null;
        TreeNode root = new TreeNode(preorder[prelow]);
        int i = inlow;
        while(preorder[prelow] != inorder[i]) i++;

        int count = i - inlow;

        root.left = Builder(prelow+1,prelow + count ,preorder,inlow , i - 1 ,inorder);
        root.right = Builder(prelow + count +1,prehi ,preorder,i + 1 , inhi ,inorder);
        return root;
    }

}