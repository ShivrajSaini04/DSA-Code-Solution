class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String , Integer> map = new HashMap<>();
        int idx = 0;
        int minSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();

        for (String str : list2) map.put(str, idx++); 

        for (int i = 0;i<list1.length;i++){
           
            if (map.containsKey(list1[i])){
                int sum  =  i + map.get(list1[i]);
                
                if (minSum > sum ){
                    list.clear();
                    minSum = sum;
                    list.add(list1[i]);
                }
                else if (minSum == sum) list.add(list1[i]);
            }
        }
      return list.toArray(new String[0]);
    }
}