class Solution {
    public boolean canPlaceFlowers(int[] arr, int k) {
        int n = arr.length;
        if (  (k==1 && n == 1) && arr[0] == 0) return true;
        if ( n > 1 && arr[0] == 0 && arr[1] != 1) {
            arr[0] = 1;
            k--;
        }

        for(int i =1; i<n-1; i++){
            if (arr[i] == 0 && (arr[i-1] == 0 && arr[i+1] == 0)) {
              arr[i] = 1;
              k--;
            }
        }

        if (n > 1 && arr[n - 1] == 0 && arr[n-2] == 0) {
            arr[n -1] = 1;
            k--;
        }

        return k <= 0;
    }
}