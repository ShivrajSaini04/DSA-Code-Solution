class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

       for(int[] row : reservedSeats) {
         map.putIfAbsent(row[0], new HashSet<>());
         map.get(row[0]).add(row[1]);
       }

       int ans = (n - map.size()) * 2;

       for( Set<Integer> set : map.values()){
          boolean left = true , right = true , middle = true;

          for (int i=2; i <= 5; i++){
            if (set.contains(i)) {
                left = false;
                break;
            }
          }

          for (int i=4; i <= 7; i++){
            if (set.contains(i)) {
                middle = false;
                break;
            }
          }

          for (int i=6; i <= 9; i++){
           if (set.contains(i)) {
                right = false;
                break;
            }
          }

          if (left && right) ans += 2;
          else if (left || middle || right)  ans += 1;

       }

       return ans;
    }
}