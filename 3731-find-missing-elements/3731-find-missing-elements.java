class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int max= Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;

        for (int ele : nums) {
             min=Math.min(min,ele);
            max=Math.max(max,ele);   
        }

        int[] arr = new int[max+1];
        for (int ele : nums) arr[ele]++;

        for (int i = min; i <= max; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}