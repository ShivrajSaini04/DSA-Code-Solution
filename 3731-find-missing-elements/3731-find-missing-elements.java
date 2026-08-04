class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int max= Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
     HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
             min=Math.min(min,ele);
            max=Math.max(max,ele);
            set.add(ele);
        }
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}