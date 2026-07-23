class Solution {
    public List<List<Integer>> shiftGrid(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int size = m*n;
        int[] arr = new int[size];
        List<List<Integer>> ans = new ArrayList<>();
        k %= (size);
        int idx =-1;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++) arr[++idx] = mat[i][j];
        }

        reverse(arr,0,size-k-1);
        reverse(arr,size-k, size-1);
        reverse(arr,0, size-1);
          
        idx =-1;
        for(int i=0;i<m;i++){
            List<Integer> list = new ArrayList<>();
            for(int j =0;j<n;j++) {
                list.add(arr[++idx]);
            }
            ans.add(list);
        }
        return ans;
    }
    
    void reverse(int[] arr , int i , int j){
        while(i<j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}